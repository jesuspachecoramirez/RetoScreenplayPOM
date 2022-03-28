# new feature
# Tags: optional

Feature: Log in para usuarios
  Como cliente con una cuenta creada en la tienda de YourLogo
  quiero poder iniciar sesion en la pagina web
  para poder utilizar los servicios en linea que tienen

  Background: Cuenta existente en la pagina web
    Given que el usuario ya tiene una cuenta
    And accede al home para ir a la seccion de log in

  Scenario: Log in de usuario exitoso
    When el usuario digita su email y su contrasena correctamente y valida la accion
    Then el usuario accede correctamente al inicio de su cuenta

  Scenario: Log in de usuario fallido por contrasena incorrecta
    When el usuario digita su email y una contrasena incorrecta y valida la accion
    Then el usuario observa un mensaje de error por fallo en autenticacion