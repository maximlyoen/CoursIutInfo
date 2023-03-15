<?php
// src/Service/AddressAPIService
namespace App\Services;

use GuzzleHttp\Client;

class AddressAPIService
{
    public const base_uri = 'https://api-adresse.data.gouv.fr/';
    public static function getLngLat(string $address): ?array {
        $client = new Client([
            'base_uri' => self::base_uri,
            'verify' => false,
        ]);
        $response = $client->request('GET', 'search', [
            'query' => [
                'q' => $address,
            ],
        ]);
        $data = json_decode($response->getBody()->getContents(), true);
        if (count($data['features']) > 0) {
            return $data['features'][0]['geometry']['coordinates'];
        }
        return null;
    }

    public function getAddresses(array $lnglat): array {
        $client = new Client([
            'base_uri' => self::base_uri,
        ]);
        $response = $client->request('GET', 'reverse', [
            'query' => [
                'lon' => $lnglat[0],
                'lat' => $lnglat[1],
            ],
        ]);
        $data = json_decode($response->getBody()->getContents(), true);
        return $data['features'][0]['properties']['address'];
    }

}