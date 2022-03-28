# new feature
# Tags: optional

Feature: Atencion al cliente para visitantes de la pagina web
  Como visitante de la pagina web de YourLogo
  quiero poder enviar un mensaje a la tienda
  sobre alguna inquietud o necesidad que tengo

  Scenario:  Visitante de la pagina quiere acceder a la opcion de Contact Us
    When el usuario visitante de la pagina se encuentra en el home
    Then existe una opcion de Contact Us y accede
    And  aparece un formulaio para llenar

  Scenario: Envio de mensaje para contacto exitoso
    Given el usuario visitante se encuentra en la pagina de Contact us
    When llena la informacion de los campos obligatorios y valida su accion
    Then aparece un mensaje de envio exitoso