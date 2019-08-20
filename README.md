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

        + **Have the PiDigits.getDigits() function receive as an additional parameter an N value, corresponding to the number of threads between which the solution is to be parallelized. Have that function wait until the N threads finish solving the problem to combine the answers and then return the result. For this, review the join method of the Java concurrency API.**

        + **Adjust the JUnit tests, considering the cases of using 1, 2 or 3 threads (the last one to consider an odd number of threads!)**
    ----
    + ## Part 3:
    ----
+ # **Dogs Race case**
    + ## Part 1:
    ----
    + ## Part 2:
    ----
    + ## Part 3:
    ----
