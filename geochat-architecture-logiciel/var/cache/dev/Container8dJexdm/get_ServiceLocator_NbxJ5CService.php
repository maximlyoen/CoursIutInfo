<?php

namespace Container8dJexdm;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_NbxJ5CService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.nbxJ5_c' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.nbxJ5_c'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService, [
            'em' => ['services', 'doctrine.orm.default_entity_manager', 'getDoctrine_Orm_DefaultEntityManagerService', false],
            'messageRepository' => ['privates', 'App\\Repository\\MessageRepository', 'getMessageRepositoryService', true],
            'serializer' => ['privates', 'debug.serializer', 'getDebug_SerializerService', true],
            'validator' => ['privates', 'debug.validator', 'getDebug_ValidatorService', false],
        ], [
            'em' => '?',
            'messageRepository' => 'App\\Repository\\MessageRepository',
            'serializer' => '?',
            'validator' => '?',
        ]);
    }
}
