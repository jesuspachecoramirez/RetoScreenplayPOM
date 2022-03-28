# new feature
# Tags: optional

Feature: Log in para Clientes
  Como cliente poseo una cuenta en la tienda de YourLogo
  quiero poder iniciar sesion en la pagina web
  para poder utilizar los servicios de la misma

  Background: Cuenta existente en la pagina web
    Given el cliente ya tiene una cuenta creada
    And accede al home de la pagina y va a la seccion de log in

  Scenario: Log in de cliente exitoso
    When el cliente digita su email y su contrasena correctamente y presiona signin
    Then el cliente accede correctamente a su cuenta

  Scenario: Log in de cliente fallido por contrasena incorrecta
    When el cliente digita su email y su contrasena no es correcta al presionar signin
    Then el cliente recibe un mensaje de error en la autenticacion