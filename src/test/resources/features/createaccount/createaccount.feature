# new feature
# Tags: optional

Feature: Creacion de nuevos usuarios
  Como cliente de la tienda YourlOGO
  quiero poder registrame en su pagina web
  para tener acceso a los servicios de la misma

  Background: Cliente accede a la pagina
    Given el cliente se encuentra en la pagina Authentication

  Scenario: Validacion de correo electronico exitoso
    When el cliente ingresa en la seccion de creacion de cuenta y digita un email valido
    Then la pagina redirecciona al cliente correctamente para que ingrese la informacion restante

  Scenario: Registro exitoso de nuevo cliente
    Given El correo del cliente es valido y se encuentra en la seccion donde ingresa la informacion restante
    When el cliente ingresa su infomacion en los campos obligatorios y presiona register
    Then recibe un mensaje de que su registro fue exitoso