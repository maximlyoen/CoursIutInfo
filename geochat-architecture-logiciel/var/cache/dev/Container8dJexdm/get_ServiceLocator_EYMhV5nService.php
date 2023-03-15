<?php

namespace Container8dJexdm;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_EYMhV5nService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.eYMhV5n' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.eYMhV5n'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService, [
            'message' => ['privates', '.errored..service_locator.eYMhV5n.App\\Entity\\Message', NULL, 'Cannot autowire service ".service_locator.eYMhV5n": it needs an instance of "App\\Entity\\Message" but this type has been excluded in "config/services.yaml".'],
            'messageRepository' => ['privates', 'App\\Repository\\MessageRepository', 'getMessageRepositoryService', true],
        ], [
            'message' => 'App\\Entity\\Message',
            'messageRepository' => 'App\\Repository\\MessageRepository',
        ]);
    }
}