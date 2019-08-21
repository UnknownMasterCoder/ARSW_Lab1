# ARSW_Lab1
Laboratorio 1 de ARSW
# Group:
+ **PEDRO JOSE MAYORGA NAVARRETE** - *Initial work* - [unknownmastercoder](https://github.com/unknownmastercoder)
+ **ANDRES DAVID VASQUEZ IBAÑEZ** - *Initial work* - [VASHIGO](https://github.com/vashigo)
----
                
+ # **BBP Formula**
    + ## Part 1:
        + **As reviewed in the readings, complete the CountThread classes, so that they define the life cycle of a thread that prints the numbers between A and B.**

        ```java
        public class CountThread extends Thread {

            private final int A;
            private final int B;
            private Thread t;
            private final String threadName;

            public CountThread(String name, int in, int out) {
                this.threadName = name;
                this.A = in;
                this.B = out;
            }

            @Override
            public void run() {
                for (int i = A; i <= B; i++) {
                    System.out.println("Thread: " + threadName + ", " + i);
                }
            }

        }
        ```

        + **Complete the main method of the CountMainThreads class so that:**
            + **Create 3 threads of type CountThread, assigning the first one the interval [0..99], the second one [99..199], and the third one [200..299].**
            ```java
            public static void main(String a[]) {
                CountThread T1 = new CountThread("1",0,99);
                CountThread T2 = new CountThread("2",100,199);
                CountThread T3 = new CountThread("3",200,299);
            }
            ```
            + **Start all three threads with start()**
            ```java
            public static void main(String a[]) {
                CountThread T1 = new CountThread("1",0,99);
                T1.start(); //start()
                CountThread T2 = new CountThread("2",100,199);
                T2.start(); //start()
                CountThread T3 = new CountThread("3",200,299);
                T3.start(); //start()
            }
            ```
            + **Run and check the output on screen.**
            
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1tIpGmdUyY9V3hAF-WXxXu0Sblb3hYaht" />
            </p>

            + **Change the beginning with start() to run(). How does the output change? Why?**

            ```java
            public static void main(String a[]) {
                CountThread T1 = new CountThread("1",0,99);
                T1.run(); //run()
                CountThread T2 = new CountThread("2",100,199);
                T2.run(); //run()
                CountThread T3 = new CountThread("3",200,299);
                T3.run(); //run()
            }
            ```

            > La diferencia es que cuando se llama al método **start()** , se crea un nuevo subproceso y el código dentro de **run()** se ejecuta en un nuevo subproceso mientras que si se llama al método **run()** directamente no se creará un nuevo subproceso y el código dentro de **run()** se ejecutara en el hilo actual directamente.

            <table style="width:100%">
            <tr>
            <th align="center">
            thread 1
            </th>
            <th align="center">
            thread 2
            </th>
            <th align="center">
            thread 3
            </th>                        
            </tr>
            <tr>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1tIpGmdUyY9V3hAF-WXxXu0Sblb3hYaht" />
            </p>
            </th>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1AzVFmsaiA_STjHQTTgzarjoLTmOPDAF5" />
            </p>
            </th>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1A3oiMwgs8cuoqlG29R-y1LvlUc7zMOma" />
            </p>
            </th>
            </tr>
            </table>
    ----
    + ## Part 2:
        + **Create a Thread type class that represents the life cycle of a thread that calculates a portion of the required digits.** 

        ```java
        public class ThreadPi extends Thread{
            private final int A;
            private final int B;
            private String res;

            public ThreadPi(String name, int in, int out){//, int hilos) {
                this.A = in;
                this.B = out;
                this.res = "";
                //this.N = hilos;
            }
            @Override
            public void run() {
                byte[] digits;
                digits = PiDigits.getDigits(A, B);
                res = ParallelCalculation.bytesToHex(digits);
            }
            public String getValue() {
                return res;
            }
        }
        ```

        + **Have the PiDigits.getDigits() function receive as an additional parameter an N value, corresponding to the number of threads between which the solution is to be parallelized. Have that function wait until the N threads finish solving the problem to combine the answers and then return the result. For this, review the join method of the Java concurrency API.**

        > Creamos otra funcion llamada **ParallelCalculation** con su metodo **calculate()** donde alli creabamos los n hilos dependiendo del parametro N recibido y cada hilo haria su pequeña calculo de fraccion dependiendo un inicio y fin.

        ```java
        public class ParallelCalculation {
            
            private final int digitsNumber;
            private final int threadsNumber;
            private double width;
            private final int[] array;
            private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

            public ParallelCalculation(int digits, int N) {
                this.digitsNumber = digits;
                this.threadsNumber = N;
                this.array = new int[N];
                //calcular tamaño cada hilo
                int div = digits / N;
                int mod = digits % N;
                int suma = div;
                for(int i = 0; i < N ; i++){
                    if(i+1 == N){
                        this.array[i]=suma+mod;
                    }else{
                        this.array[i]=suma;
                    }
                }
            }
            
            public String calculate() throws InterruptedException{
                
                ThreadPi threads[] = new ThreadPi[threadsNumber];
                width = 1.0 / (double) digitsNumber;
                int[] intArray = new int[] {3,3,4};
                for (int i=0; i < threadsNumber; i++){
                    long start =  i * digitsNumber/threadsNumber;
                    long count =   digitsNumber/threadsNumber;
                    //int end = (i+1) * (digitsNumber/threadsNumber);
                    threads[i] = new ThreadPi(Integer.toString(i), (int)start, (int)this.array[i]);
                    threads[i].start();
                }
                
                //Join all the threads
            
                String res = "";
                for (int i = 0; i < threadsNumber; i++) {
                    threads[i].join();
                    res += threads[i].getValue();
                }
            
                System.out.println("\nRes: "+res+"\n");
                return res;
            }
            
            public static String bytesToHex(byte[] bytes) {
                char[] hexChars = new char[bytes.length * 2];
                for (int j = 0; j < bytes.length; j++) {
                    int v = bytes[j] & 0xFF;
                    hexChars[j * 2] = hexArray[v >>> 4];
                    hexChars[j * 2 + 1] = hexArray[v & 0x0F];
                }
                StringBuilder sb=new StringBuilder();
                for (int i=0;i<hexChars.length;i=i+2){
                    //sb.append(hexChars[i]);
                    sb.append(hexChars[i+1]);            
                }
                return sb.toString();
            }
        }        
        ```

        + **Adjust the JUnit tests, considering the cases of using 1, 2 or 3 threads (the last one to consider an odd number of threads!)**

        > Creamos 3 pruebas cada una pues como dice para 1, 2 y 3 hilos respectivamente considerando un rango de 100 digitos

        ```java
        @Test
        public void piGenTest_1thread() throws InterruptedException {
            //Resultado esperado obtenido de Wolfram alpha
            String expected = "243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC";
            
            ParallelCalculation test1 = new ParallelCalculation(100,1);
            String obtained = test1.calculate();        
            assertEquals(expected, obtained);
        }
        
        /**
        *
        * @throws InterruptedException
        */
        @Test
        public void piGenTest_2thread() throws InterruptedException {
            //Resultado esperado obtenido de Wolfram alpha
            String expected = "243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC";
            
            ParallelCalculation test2 = new ParallelCalculation(100,2);
            String obtained = test2.calculate();        
            assertEquals(expected, obtained);
        }
        
        /**
        *
        * @throws InterruptedException
        */
        @Test
        public void piGenTest_3thread() throws InterruptedException {
            //Resultado esperado obtenido de Wolfram alpha
            String expected = "243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC";
            
            ParallelCalculation test3 = new ParallelCalculation(100,3);
            String obtained = test3.calculate();        
            assertEquals(expected, obtained);
        }
        ```
        > los resultados de las pruebas fueron satisfactorios y arrojaron la siguiente respuesta:

        
        > -------------------------------------------------------
        > T E S T S
        > -------------------------------------------------------
        > Running edu.eci.arsw.math.PiCalcTest
        >       
        > Res: 243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC
        >
        >
        > Res: 243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC
        >
        >
        > Res: 243F6A8885A308D313198A2E03707344A4093822299F31D0082EFA98EC4E6C89452821E638D01377BE5466CF34E90C6CC0AC
        >
        > Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.193 sec
        >
        > Results :
        >
        >Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
        >
        > ------------------------------------------------------------------------
        > BUILD SUCCESS
        > ------------------------------------------------------------------------
        
    ----

    + ## Part 3:
        + **From the above, implement the following sequence of experiments to calculate the million digits (hex) of PI, taking their execution times (be sure to do them on the same machine):**

            + **Single thread.**
            > **con 1 hilo** no hubo un buen aprovechamiento del procesador y se está desperdiciendo recursos

            <table style="width:100%">
            <tr>
            <th align="center">
            procesos y memoria
            </th>
            <th align="center">
            numero de hilos
            </th>                      
            </tr>
            <tr>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1HjzAjIbkK1BY5nyVCE2R4_lxe6yU5U2L" />
            </p>
            </th>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1WvV1QoV6aDAeiNm1laC2WDhueExyvMqm" />
            </p>
            </th>
            </tr>
            </table>

            + **As many threads as processing cores (have the program determine this using the Runtime API).** 

            > **con 8 hilos** hubo un buen aprovechamiento del procesador y de recursos

            <table style="width:100%">
            <tr>
            <th align="center">
            procesos y memoria
            </th>
            <th align="center">
            numero de hilos
            </th>                      
            </tr>
            <tr>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1pB7UCbD0SdnlW-Sg8SwpQjkXvNpQJMTD" />
            </p>
            </th>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1SnvWj3hV36XHEsYyjrXRVuWE9nsiNkaf" />
            </p>
            </th>
            </tr>
            </table>

            + **So many threads as double processing cores.** 

            > **con 16 hilos** ya se esta dando un estres innecesario al procesador

            <table style="width:100%">
            <tr>
            <th align="center">
            procesos y memoria
            </th>
            <th align="center">
            numero de hilos
            </th>                      
            </tr>
            <tr>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1ItWluqwucu627ZTYqvv2DVbJFTXM3I1A" />
            </p>
            </th>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1aoMu65rDdadZSH1wGyXvyqmM6AfRst4i" />
            </p>
            </th>
            </tr>
            </table>

            + **200 threads.**

            > **con 200 hilos** ya se esta dando un super estres innecesario al procesador demas

            <table style="width:100%">
            <tr>
            <th align="center">
            procesos y memoria
            </th>
            <th align="center">
            numero de hilos
            </th>                      
            </tr>
            <tr>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1dOl71xw8NIJx4f6nlK1ka40KdAJKyL9G" />
            </p>
            </th>
            <th>
            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1TRoeaE8wsfhgiB_v2YEqrsmS5ad3wK51" />
            </p>
            </th>
            </tr>
            </table>

            + **500 threads** 
            > **con 500 hilos** no soporto el proceso y el computador donde se probo no respondio.

        + **According to Amdahls law, where S (n) is the theoretical performance improvement, P the parallel fraction of the algorithm, and n the number of threads, the greater n, the greater the improvement should be. Why is the best performance not achieved with the 500 threads? How does this performance compare when 200 are used?.**  

            > Por que al usar 500 hilos se están excediendo las capacidades del procesador, tomando en cuenta que procesadores de por ejemplo 8 nucleos se encuentran diseñados para soportar hasta 16 hilos de procesos.
            El desempeño al usar 500 es imposible por la misma razón anterior, lo cual comparado con una ejecución de 200 hilos, aunque también es casi imposible y el procesador trata de resolverlo, no resiste tanto y al final se nota como los procesos atascan los demás procesos que esté ejecutando el computador, aunque de manera no tan drástica a el caso de 500 hilos.

        + **How does the solution behave using as many processing threads as cores compared to the result of using twice as much?**

            > El comportamiento de la solución con tantos hilos como nucleos (8) ha sido la solución más optima posible porque se estaban usando el mismo numero de procesos que nucleos, sin embargo el de 16 hilos aunque no se dejaba colgar por el numero de nucleos del procesador si se notó que perdia capacidad de procesamiento.

        + **According to the above, if for this problem instead of 500 threads on a single CPU, 1 wire could be used on each of 500 hypothetical machines, would Amdahls's law be better applied? If, instead, c threads were used in 500 / c distributed machines (where c is the number of cores of said machines), would it be improved? Explain your answer.**

            > Si un cable conectara a 500 maquinas, en teoría tendriamos 500 CPUs, de los cuales solo estaríamos usando 1 hilo por cada CPU, por lo cual mejoraría considerablemente la capacidad de procesamiento de la solucion al no sobrecargar un solo CPU como en el punto anterior, de esta manera cada CPU estaría trabajando sin necesidad de sobrecarga, pero con la velocidad de 500 hilos paralelos.
