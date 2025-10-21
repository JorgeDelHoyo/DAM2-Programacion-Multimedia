/**
 * Implementa un sistema de autenticación con diferentes tipos de usuarios: Administrador , moderador , usuario.
 * Cualquiera de estos usuarios consta de un identificador, un nombre y una dirección de correo electrónico.
 * Además esta clase Usuario contiene tres métodos:
 * * Un validador de cuentas de correos electrónicos válidas, de manera que solo se puedan crear cuentas con el email @gmail.com
 *
 * * Un validador de cuenta de usuario válida, en el que el nombre de usuario tenga entre 3 y 20 caracteres
 * * * y solo se permiten caracteres alfanuméricos y el caracter _
 *
 * * Un metodo que autentica al usuario siempres y cuando los dos validadores anteriores sean correctos.
 * * * En este caso creará un objeto de tipo Usuario con los datos correspondientes.
 *
 * Cuando un usuario intenta inciar sesión tendrá tres posibles resultados:
 * * Éxito  (si el email y el nombre de usuario validos  )-> en cuyo caso se creará el objeto usuario
 * * Error -> mostrará un mensaje de error
 * * Cargando -> mostrará un mensaje en la pantalla de “Cargando información ..”
 *
 */

enum class TipoUsuario{
    Administrador, Moderador, Usuario
}