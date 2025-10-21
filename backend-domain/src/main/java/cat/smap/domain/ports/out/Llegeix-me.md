# Package domain/ports/out
Les interfícies out o adapters, defineixen aquells contractes que, les classes Repository implementaran i  
que les classes Services podran invocar mitjançant la interfície per separar la capa de la lògica de negoci  
de la capa de persistència.

Garantint així què els canvis efectuats en una capa, no puguin trencar a l'altre.