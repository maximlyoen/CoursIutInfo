<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\MessageRepository;
use App\Services\AddressAPIService;
use FOS\RestBundle\Controller\Annotations\View;
use Symfony\Component\HttpFoundation\Request;
use App\Entity\Message;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;
use OpenApi\Annotations as OAA;
use OpenApi\Attributes as OA;


#[Route('/api')]

class ApiController extends AbstractController
{
    /**
     * @OAA\Get(
     *    path="/api/messages",
     *   summary="Get messages",
     *  tags={"Messages"},
     * @OAA\Parameter(
     *    name="address",
     *   in="query",
     * description="Address",
     * required=true,
     * @OAA\Schema(
     *   type="string"
     * )
     * ),
     * @OAA\Response(
     *  response=200,
     * description="Success"),
     * @OAA\Response(
     * response=400,
     * description="Bad request"
     * )
     * )
     * 
     */
    #[OA\Parameter(
        name: "radius",
        in: "query",
        schema: new OA\Schema(ref: "#/components/schemas/Radius"),
    )]
    #[Route('/messages', name: 'api_messages', methods: ['GET'])]
    #[View(serializerGroups: ['message_basic'])]
    public function getMessages(Request $request, MessageRepository $messageRepository): array
    {
        $address = $request->query->get('address');
        $radius = $request->query->get('radius', 2);
        $lnglat = AddressAPIService::getLngLat($address);

        // Vérification des paramètres GET
        if (!$address) {
            return $this->json(['error' => 'Address parameter is required.'], Response::HTTP_BAD_REQUEST);
        }

        // Récupération des messages dans le rayon spécifié
        $messages = $messageRepository->findClose($lnglat[0], $lnglat[1], $radius * 1000)
            ->setMaxResults(10)
            ->orderBy('m.date', 'DESC')
            ->getQuery()
            ->getResult();

        return $messages;
    }

    #[Route('/message', methods: ['POST'])]
    #[View(serializerGroups: ['ajout_message'])]
    public function createMessage(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, MessageRepository $messageRepository, ValidatorInterface $validator)
    {
        
        $message = $serializer->deserialize($request->getContent(), Message::class, 'json');
        $errors = $validator->validate($message);

        if (count($errors) > 0) {
            return $this->json($errors, Response::HTTP_BAD_REQUEST);
        }
        $message->setLongitude(0);
        $message->setLatitude(0);
        $messageRepository->save($message, true);
        $em->flush();

        return ['message' => $message];
    }
}
