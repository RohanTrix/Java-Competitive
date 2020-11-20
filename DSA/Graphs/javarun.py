import os
import time
prog_name = "*.java"
os.system(f'javac -d Classes {prog_name}')
t1 = time.time()
os.system(f'java -cp Classes SSSP_Dag')
t2 = time.time()
print("TIME TAKEN: ",t2-t1)