# ARSW_Lab1
Laboratorio 1 de ARSW
# Group:
+ **PEDRO JOSE MAYORGA NAVARRETE** - *Initial work* - [unknownmastercoder](https://github.com/unknownmastercoder)
+ **ANDRES DAVID VASQUEZ IBAÑEZ** - *Initial work* - [VASHIGO](https://github.com/vashigo)
----
                
+ # **BBP Formula**
    + ## Part 1:
        + **As reviewed in the readings, complete the CountThread classes, so that they define the life cycle of a thread that prints the numbers between A and B.**

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

            <p align="center">
            <img src="https://drive.google.com/uc?export=view&id=1EyrHb76wGqrKD5GakdXPh6dCCoXz_Gg-" />
            </p>
    ----
    + ## Part 2:
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
