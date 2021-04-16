# ARRIETA-NIETO-CHACON-POOB-2021-1-LAB-EXCEPTIONS

PARTE I
¿Cómo se propaga una excepción en JAVA?

Para lanzar una excepción en tiempo de ejecución se usar la palabra clave throw junto a una instancia de la excepción que queremos lanzar


¿Cómo se propaga una excepción en JAVA?

la excepción se propaga hacia el método que lo haya invocado y se busca allí el código que la trate. Si tampoco este método dispone del código adecuado, se propagara a su vez al que lo haya invocado
  

¿Cómo se captura una excepción en JAVA?

Los bloques try...catch se utilizan en Java para capturar la excepciones 

¿Cuál es la diferencia en la implementación de las pruebas? ¿Validan lo mismo?

Las excepciones pueden definir, lanzar y gestionar excepciones lo cual permite un mayor manejo en el código.





PARTE IV 

1)	
¿Por qué el compilador muestra estos errores?

En los métodos pueden salir excepciones que no se consideran en sabanapayroll ya que estas 2 clases( familycompensationfund) se generan excepciones que no están chequeadas(uncheked) en Sabanapayroll

2)	¿Qué debemos hacer para controlarlos?

Se utiliza el throw exceptions
	

3)¿Deben ser las excepciones en SabanaPayroll controladas o propagadas?	

Deben ser propagadas ya que controlar la excepción se maneja en otra clase del código 
