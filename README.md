DS - PR1

# Autor: Julen San Alejo . UOC 

## URL DEL REPOSITORIO 
   [url]https://github.com/julenbatbatbi/PR1_ED
    

## Intrducción

    Para comenzar. Este Código ha sido llevado a cabo siguiendo la estrategia pedida, TDD.
    Todas las funciones han sido en un principio implementadas de forma minimalista para poder
    satisfacer los tests que venían definidos.

    Más tarde, algunas de las funciones o clases han sido amoldadas a mi gusto o optimizadas
    
### Notas 
    
    Por falta de tiempo (me ha pillado un poco el toro) no me ha sido posible añadir la parte de los test
    adicionales.

    Me gustaría poder implementar alguno, aunque fuesen fuera de la fecha de entrega y probablemente no me
    los vayas a dar por válidos.


## PASO 1
    Implementar todas las funciones  y clases definidas en los tests. Hasta conseguir ejecutar estos (fallando
    todos, evidentemente)

## PASO 2
    Pasar los tests y optimizar partes del código o amoldarlas a mi gusto.

# EXPLICACIÓN DEL CÓDIGO

    Las estructuras de datos utilizadas han sido las especificadas en la PEC1.
    Sin embargo, parte de los algoritmos no han seguido la definición y complejidad especificada en la PEC1

    Algunos de los ficheros, necesitan una especial mención o explicación.

### `OrderedVector`
    A pesar de tener disponibles ejemplos de semestres anteriores, decidí implementar por mi mismo todas las
    funcionalidades.

    Los métodos implementados por Mi:
        findIndex -> Busca el índice del valor buscado, haciendo uso de comparable y una binary search
                    En la binary search, sobra el último if.
        
        update -> éste método inserta un nuevo valor en caso de que haya sitio disponible.
                  En caso de que no haya sitio disponible y el valor que se quiera introducir sea menor
                  al mínimo, reemplazará este.

                  ----------BUG-----------
                  Como vemos en el algoritmo, intentará reemplazar el último indice. Esto satisface los tests,
                  Sin embargo, si se diese el caso en Events. que se introduciesen nuevos ratings, el vector aún 
                  no estaría re-ordenado y cabe la posibilidad de que ese índice no tuviese el valor mínimo
                  dando sitio a un bug.

                  De momento no lo he modificado, pues son las 24:50 y estoy escribiendo esto

        Los métodos introducidos por mi son sort(), slice(), merge() y setIntoArray()

        Creo que los nombres explican bastante bien su funcionalidad
        La complejidad algoritmica como la espacial no es la más óptima, pues en muchos casos no es necesario 
        re-ordenar el vecto, por ejemplo si fuesemos a introducir 1 simple índice a un vector ordenado, por qué reordenarlo
        entero ?

### `ResourceUtil`

    En este ficher, como vemos, los Utils o Recursos se representan mediante valores binarios.
    Siendo que tv (no es exactamente así)  00000001,  proyector 1000000 etc...
    por lo tanto para representar un conjunto, tan solo deberemos aplicar el operador or

    TV + PROYECTOR  00000001 | 10000000 -> 10000001
    
    Para saber si un recurso está presente, simplemente deberemos aplicar el operador lógico and y ver si coincide
    con el valor del recurso que queremos.

    c'est fini.

### `Exceptions`

     Las excepciones no son más que simples extensiones de la excepción base que teníamos en el proyecto por defecto
      No implementan ninguna otra funcionalidad y son meramente nombres descriptivos de los errores (en mi caso)

###  Model
      Por lo general en la clase Model, he decidido delegar muchas de las funciones declaradas en UniversityEventsImpl
      a las propias clases, siendo que estas tengan la responsabilidad de calcular las operaciones asociadas a sus clases

      Debo hacer hincapié en que no todos los métodos siguen esta norma.

#### Simplicidad UniversityEventsImpl

        He intentado que los métodos dentro de esta clase, sean lo más simples posibles, fáciles de entender
        y bastante expresivos. No sé si lo he con conseguido, pero yo al menos lo he intentado.

##### updateEvent
        
        Doy mención especial a esta función, a parte de (me ha dicho un pajarito) las union types son una muy mala práctica
        Para poder castear una clase a su subclase, primero debió ser instanciada como esta subclase.

        Al hacer update e intentar cambiar el tipo de 'Entity' se debe reemplazar, por lo tanto, el nombre update resulta un
        poco engañoso, al menos para este caso específico.

### Clases Abstractas AbstractIdArryImpl y ElementWithId

        No me gustó tener que definir varios métodos practicamente idénticos. Por eso diseñé una clase abstracta
        que albergase los métodos de update, find ... y no sé si alguno más

        Como utilicé un tipo genérico T,  no podía llamar a una función que no estuviese definida.
        Como todas las instancias de esta clase compartian Id, extendí el tipo genérico para poder utilizar
        El método getId()

    



    
    