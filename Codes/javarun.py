# Compile All, Run Desired Java program
import os
import time
while(True):
    if input()=='q':
        break
    prog_name = "*.java"
    os.system(f'javac -d Classes {prog_name}')
    t1 = time.time()
    os.system(f'java -cp Classes My_Fast_IO')
    t2 = time.time()
    print("TIME TAKEN: ",t2-t1)