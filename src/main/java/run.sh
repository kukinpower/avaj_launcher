find . -name "*.java" > src.txt
javac -sourcepath . @src.txt
java com.mkristie.avajlauncher.Main scenario.txt
find . -name "*.class" -delete && rm -f simulation.txt src.txt
