import greenfoot.*;

public class Link2 extends Actor {
    private GifImage walkRightAnimation;
    private GifImage idleAnimation;
    private GifImage walkLeftAnimation;
    private GifImage jumpAnimation;
    private GifImage ataque1Animation;
    private GifImage ataque2Animation;
    private GifImage ataque3Animation;
    private int moveSpeed;
    private int vSpeed;
    private int acceleration;
    private int jumpStrength;
    private int attackCount;

    public Link2() {
        walkRightAnimation = new GifImage("linkrun.gif");
        idleAnimation = new GifImage("idlePose.gif");
        walkLeftAnimation = new GifImage("runLeftLink.gif");
        jumpAnimation = new GifImage("JumpLink.gif");
        ataque1Animation = new GifImage("ataque1.gif");
        ataque2Animation = new GifImage("ataque1.gif");
        ataque3Animation = new GifImage("ataque1.gif");

        moveSpeed = 3;
        vSpeed = 0;
        acceleration = 1;
        jumpStrength = 18;
        attackCount = 0;
    }

    public void act() {
        handleMovement();
        handleJump();
        handleAttack();
    }

    private void handleMovement() {
        int moveX = 0;

        if (Greenfoot.isKeyDown("right")) {
            moveX = moveSpeed;
            setImage(walkRightAnimation.getCurrentImage());
        } else if (Greenfoot.isKeyDown("left")) {
            moveX = -moveSpeed;
            setImage(walkLeftAnimation.getCurrentImage());
        } else {
            setImage(idleAnimation.getCurrentImage());
        }

        setLocation(getX() + moveX, getY());
    }

    private void handleJump() {
        if (onGround()) {
            vSpeed = 0;

            if (Greenfoot.isKeyDown("up")) {
                vSpeed -= jumpStrength;
            }
        } else {
            vSpeed += acceleration;
            setImage(jumpAnimation.getCurrentImage());
        }

        setLocation(getX(), getY() + vSpeed);
    }

    private void handleAttack() {
        if (Greenfoot.isKeyDown("p") && attackCount == 0) {
            setImage(ataque1Animation.getCurrentImage());
            attackCount++;
        } else if (attackCount == 1) {
            setImage(ataque2Animation.getCurrentImage());
            attackCount++;
        } else if (attackCount == 2) {
            setImage(ataque3Animation.getCurrentImage());
            attackCount++;
        } else if (attackCount == 3) {
            setImage(ataque1Animation.getCurrentImage());
            attackCount = 0;
        }
    }

    private boolean onGround() {
        int groundHeight = getImage().getHeight() / 2;
        int groundOffset = 10;

        Actor ground = getOneObjectAtOffset(0, groundHeight + groundOffset, chao.class);

        return ground != null;
    }
}
