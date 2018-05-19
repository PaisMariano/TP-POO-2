[33mcommit 1b71906f0f617c53e6dfa3fdb3e175b00510bb81[m
Author: UnderABloodySky <valenzuelahoracioe@gmail.com>
Date:   Sat May 19 15:29:16 2018 -0300

    Agrego la clase Equipo

[1mdiff --git a/Prueba b/Prueba[m
[1mdeleted file mode 100644[m
[1mindex 5f76874..0000000[m
[1m--- a/Prueba[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-Prueba Mariano[m
[1mdiff --git a/README.md b/README.md[m
[1mdeleted file mode 100644[m
[1mindex c6e229f..0000000[m
[1m--- a/README.md[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-# TP-POO-2 PRUEBA[m
[1mdiff --git a/TP INTEGRADOR OBJ.xml b/TP INTEGRADOR OBJ.xml[m
[1mdeleted file mode 100644[m
[1mindex d46a8ff..0000000[m
[1m--- a/TP INTEGRADOR OBJ.xml[m	
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-<mxfile userAgent="Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0" version="8.6.5" editor="www.draw.io" type="device"><diagram id="9d5fcea5-9832-1601-4e21-4c6528a454ad" name="Page-1">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</diagram></mxfile>[m
\ No newline at end of file[m
[1mdiff --git a/TP-POO-2 b/TP-POO-2[m
[1mindex 76cc4c2..cf76603 160000[m
[1m--- a/TP-POO-2[m
[1m+++ b/TP-POO-2[m
[36m@@ -1 +1 @@[m
[31m-Subproject commit 76cc4c248f8b3f9049578f4eec9497d905e6fe9e[m
[32m+[m[32mSubproject commit cf7660366c67b13b76ac5e754870303a82d69c1d[m
[1mdiff --git a/TpFinalJava/.classpath b/TpFinalJava/.classpath[m
[1mdeleted file mode 100644[m
[1mindex fb50116..0000000[m
[1m--- a/TpFinalJava/.classpath[m
[1m+++ /dev/null[m
[36m@@ -1,6 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<classpath>[m
[31m-	<classpathentry kind="src" path="src"/>[m
[31m-	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>[m
[31m-	<classpathentry kind="output" path="bin"/>[m
[31m-</classpath>[m
[1mdiff --git a/TpFinalJava/.gitignore b/TpFinalJava/.gitignore[m
[1mdeleted file mode 100644[m
[1mindex ae3c172..0000000[m
[1m--- a/TpFinalJava/.gitignore[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-/bin/[m
[1mdiff --git a/TpFinalJava/.project b/TpFinalJava/.project[m
[1mdeleted file mode 100644[m
[1mindex 8a59cdb..0000000[m
[1m--- a/TpFinalJava/.project[m
[1m+++ /dev/null[m
[36m@@ -1,17 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<projectDescription>[m
[31m-	<name>TpFinalPOO2</name>[m
[31m-	<comment></comment>[m
[31m-	<projects>[m
[31m-	</projects>[m
[31m-	<buildSpec>[m
[31m-		<buildCommand>[m
[31m-			<name>org.eclipse.jdt.core.javabuilder</name>[m
[31m-			<arguments>[m
[31m-			</arguments>[m
[31m-		</buildCommand>[m
[31m-	</buildSpec>[m
[31m-	<natures>[m
[31m-		<nature>org.eclipse.jdt.core.javanature</nature>[m
[31m-	</natures>[m
[31m-</projectDescription>[m
[1mdiff --git a/TpFinalJava/src/models/Deportista.java b/TpFinalJava/src/models/Deportista.java[m
[1mdeleted file mode 100644[m
[1mindex eb4f933..0000000[m
[1m--- a/TpFinalJava/src/models/Deportista.java[m
[1m+++ /dev/null[m
[36m@@ -1,6 +0,0 @@[m
[31m-package models;[m
[31m-[m
[31m-public class Deportista {[m
[31m-	[m
[31m-[m
[31m-}[m
[1mdiff --git a/hola.txt b/hola.txt[m
[1mdeleted file mode 100644[m
[1mindex a19abfe..0000000[m
[1m--- a/hola.txt[m
[1m+++ /dev/null[m
[36m@@ -1 +0,0 @@[m
[31m-Hola[m
