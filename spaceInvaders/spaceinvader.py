import math
import turtle
import os
import random

#set up the screen
window = turtle.Screen()
window.bgcolor("black") #background color
window.title("Space Invaders")

turtle.register_shape("hello.gif")
#border setup
border_pen = turtle.Turtle()
border_pen.speed(0)# zero is the fastest speed
border_pen.color("pink")
border_pen.penup()
border_pen.setposition(-300,-300)
border_pen.pendown()
border_pen.pensize(3)

# draw a square
for side in range (4):
    border_pen.fd(600)
    border_pen.lt(90)

border_pen.hideturtle()

#scoreboard
score =0
#draw score board
score_board = turtle.Turtle()
score_board.speed(0)
score_board.color("white")
score_board.penup()
score_board.setposition(-290,280)
scoreString = "Score: %s"  %score
score_board.write(scoreString,False,align="left",font=("Arial",14,"normal"))
score_board.hideturtle()
#create the player
player = turtle.Turtle()
player.color("Yellow")
player.shape("triangle")
player.penup()
player.speed(0)
player.setposition(0,-250)
player.setheading(90)

#moving control ( player speed)
playerspeed = 15 #( 15 works well but can still adjust)


numberOfenemies = 5
#create a empty list
enemieslist = []
for i in range(numberOfenemies):
    enemieslist.append(turtle.Turtle())

for enemy in enemieslist:
    #create enemy
    enemy.color("white")
    enemy.shape("hello.gif")
    enemy.penup()
    enemy.speed(0)
    x = random.randint(-200,200)
    y = random.randint(100,250)
    enemy.setposition(x,y)

enemyspeed = 3

#create weapon
cannon = turtle.Turtle()
cannon.color("red")
cannon.shape("triangle")
cannon.penup()
cannon.speed(0)
cannon.setheading(90)
cannon.shapesize(0.5,0.5)
cannon.hideturtle()
cannonspeed = 20;

#define cannon state
#ready to fire
#fire state
cannonstate = "ready"
# need two function move left and move right


def left():
    x = player.xcor()   #get player current position
    x -=playerspeed     # minus player speed
    if x <- 280:
        x = -280
    player.setx(x)      # set player new position
def right():
    x = player.xcor()
    x += playerspeed
    if x > 280:
        x=280
    player.setx(x)
def fire():
    #declare cannon states as global
    global cannonstate
    if cannonstate =="ready":
        cannonstate="fire"
        x = player.xcor()
        y = player.ycor()
        cannon.setposition(x,y+10)
        cannon.showturtle()

def isCollision(t1,t2):
    distance = math.sqrt(math.pow(t1.xcor()-t2.xcor(),2)+math.pow(t1.ycor()-t2.ycor(),2))
    if distance < 25:
        return True
    else:
        return False

#create keyboard bindings
turtle.listen()
turtle.onkey(left,"Left")
turtle.onkey(right,"Right")
turtle.onkey(fire,"space")

print(enemieslist)
#game loop
while True:
      # move the enmeyprint(enemieslist)
    for enemy in enemieslist:
        enemy.setx(enemy.xcor()+enemyspeed)

        if enemy.xcor() >280:
            for e in enemieslist:
                y=e.ycor()
                y -= 40
                e.sety(y)
            enemyspeed *= -1
        if enemy.xcor() <-280:
            # move enemies down
            for e in enemieslist:
                y=e.ycor()
                y -= 40
                e.sety(y)
            enemyspeed *= -1
            #check the collision bullet and enemy
        if isCollision(cannon,enemy):
                #reset the cannon
            cannon.hideturtle()
            cannonstate="ready"
            cannon.setposition(0,-400)
                #reset the enemy
            x = random.randint(-200, 200)
            y = random.randint(100, 250)
            enemy.setposition(x, y)
            score +=10
            scoreString = "Score %s" %score
            score_board.clear()
            score_board.write(scoreString, False, align="left", font=("Arial", 14, "normal"))

        if isCollision(player,enemy):
            player.hideturtle()
            enemy.hideturtle()
            print("GAME OVER!!!")
            break
            # move the bullet
        if cannonstate == "fire":
            y = cannon.ycor()
            y += cannonspeed
            cannon.sety(y)

                # check if bullet hit the top border
        if cannon.ycor() > 275:
            cannon.hideturtle()
            cannonstate = "ready"


delay = input("Enter to finish")
