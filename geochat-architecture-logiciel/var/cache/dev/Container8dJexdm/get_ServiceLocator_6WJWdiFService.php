<?php

namespace Container8dJexdm;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_6WJWdiFService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.6WJWdiF' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.6WJWdiF'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService, [
            'messages' => ['privates', 'App\\Repository\\MessageRepository', 'getMessageRepositoryService', true],
        ], [
            'messages' => 'App\\Repository\\MessageRepository',
        ]);
    }
}
