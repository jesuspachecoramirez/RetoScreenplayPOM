# new feature
# Tags: optional

Feature: Creacion de nuevos usuarios
  Como usuario de la tienda YourlOGO
  quiero poder registrame en su pagina web
  para tener acceso a sus servicios en linea

  Background: Usuario accede a home de la pagina
    Given el usuario se encuentra en el home de la pagina

  Scenario: Validacion de correo electronico exitoso
    When el usuario ingresa en la seccion de registro y digita un email valido
    Then la pagina redirecciona al usuario correctamente para que ingrese su informacion

  Scenario: Registro exitoso de nuevo usuario con campos obligatorios
    Given que el usuario ha validado su correo y se encuentra en la seccion para rellenar su informacion
    When el usuario coloca su infomacion en los campos obligatorios y valida su accion
    Then observa un mensaje de que su registro fue exitoso