# new feature
# Tags: optional

Feature: Atencion al cliente para clientes de la pagina web
  Como cliente de la pagina web de YourLogo
  quiero poder enviar un mensaje a la tienda
  sobre alguna inquietud o necesidad que posea

  Scenario:  Cliente de la pagina quiere acceder a la opcion de Contact Us
    When el cliente se encuentra en el home de la pagina
    Then valida una opcion de Contact Us e ingresa
    And  aparece un formulario que debe llenar

  Scenario: Se Envia el mensaje de manera exitosa
    Given el cliente se encuentra en la pagina de Contact us
    When llena la informacion de los campos obligatorios y presiona en enviar
    Then aparece un mensaje de envio exitoso