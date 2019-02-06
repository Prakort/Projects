
#Prakort Lean
#snake game
#fun projects
#06-Feb-2019
import turtle
import time
import random
delay = 0.1

#screen setup
window = turtle.Screen()
window.title("Snack Game")
window.bgcolor("gray")
window.setup(width = 600, height = 600)
window.tracer(0)
#score board
global high_score
high_score =0
score =0
scoreboard = turtle.Turtle()
scoreboard.speed(0)
scoreboard.color("white")
scoreboard.penup()
scoreboard.hideturtle()
scoreboard.goto(0,260)
scoreline = "Score: {}  High Score: {}".format(score,high_score)
scoreboard.write(scoreline, False, align="center",font =("Arial",20,"normal"))

#score func
def scoring(x,h):
    global scoreline
    global score
    scoreline = "Score: {}  High Score: {}".format(x, h)
    scoreboard.clear()
    scoreboard.write(scoreline, False, align="center", font=("Arial", 20, "normal"))
    if x==0:
        score =0


# snacke head

head = turtle.Turtle()
head.speed(0)
head.shape("square")
head.color("yellow")
head.penup()
head.goto(0,0)
head.direction = "stop"
#food
food = turtle.Turtle()
food.speed(0)
food.shape("circle")
food.color("green")
food.penup()
food.goto(0,100)
#add body of snake

body = []

# move function
def move():
    if head.direction == "up":
        head.sety(head.ycor()+20)
    if head.direction == "down":
        head.sety(head.ycor() - 20)
    if head.direction == "left":
        head.setx(head.xcor() - 20)
    if head.direction == "right":
        head.setx(head.xcor()+ 20)


# change direction of head
def up():
    if head.direction!="down":
        head.direction ="up"
def down():
    if head.direction != "up":
        head.direction ="down"
def right():
    if head.direction != "left":
        head.direction ="right"
def left():
    if head.direction != "right":
        head.direction ="left"
def stop():
    head.direction="stop"
# game loop
#
window.listen()
window.onkey(up, "w")
window.onkey(down, "s")
window.onkey(left, "a")
window.onkey(right, "d")
window.onkey(stop,"t")
while True:
    window.update()
    #check collision with border
    if head.xcor()>290 or head.xcor()<-290 or head.ycor()>290 or head.ycor()<-290:
        time.sleep(1)
        head.goto(0,0)
        head.direction ="stop"
        scoring(0,high_score)
        #move body off screen
        for square in body:
            square.goto(1000,1000)
        #clear the body
        body.clear()
    #check snack eats food
    if head.distance(food)<20:
        food.goto(random.randint(-290,290),random.randint(-290,290))
        #add body
        new_body = turtle.Turtle()
        new_body.speed(0)
        new_body.shape("square")
        new_body.color("pink")
        new_body.penup()
        body.append(new_body)
        score += 10
        if score > high_score:
            high_score=score
        scoring(score,high_score)
    # move last end body to the second last
    for index in range(len(body)-1,0,-1):
        x = body[index-1].xcor()
        y = body[index-1].ycor()
        body[index].goto(x,y)

    #move segment 0 to the where the head is
    if len(body)>0:
        body[0].goto(head.xcor(),head.ycor())


    move()

    #check if head eats body
    for pc in body:
        if pc.distance(head) < 20:
            time.sleep(1)
            head.goto(0,0)
            head.direction="stop"

            # move body off screen
            for square in body:
                square.goto(1000, 1000)
            # clear the body
            body.clear()
            scoring(0,high_score)

    time.sleep(delay)

window.mainloop()
