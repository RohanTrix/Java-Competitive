import os
import time
import tkinter as tk
from tkinter import ttk
win = tk.Tk()  
win.title("Python GUI")
a_label = ttk.Label(win, text="A Label")
a_label.grid(column=0, row=0)
def click_me():
    if os.system('git diff --exit-code')==0:
        print(0)
        time.sleep(60)
        f = open('hw.txt','w')
        f.write("Latest push at : " + str(time.time()))
        f.close()
        return
    os.system('git add-commit -m "Committed changes"')
    os.system('git push -u origin main')
    time.sleep(60)
# Adding a button
action = ttk.Button(win, text = "Click me!", command = click_me)
action.grid(column=1, row=0)
win.mainloop()