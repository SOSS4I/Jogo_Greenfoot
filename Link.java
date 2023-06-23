import greenfoot.*;

public class Link extends Actor {
    private GreenfootImage[] idleFrames;
    private GreenfootImage[] jumpFrames;
    private GreenfootImage[] walkLeftFrames;
    private GreenfootImage[] walkRightFrames;
    private GreenfootImage[] ataqueFrames1;
    private GreenfootImage[] ataqueFrames2;
    private GreenfootImage[] ataqueFrames3;

    private GreenfootImage[] currentFrames; // Array de frames atual
    private int currentFrame;
    private int animationDelay;

    private int moveSpeed; // Velocidade de movimento do personagem
    private int vSpeed; // Velocidade vertical do personagem
    private int acceleration; // Aceleração da queda
    private int jumpStrength; // Força do salto

    private int ataqueCount; // Contador de ataques realizados

    public Link() {
        // Inicialize os arrays de frames com o número correto de imagens

        idleFrames = new GreenfootImage[4];
        jumpFrames = new GreenfootImage[6];
        walkLeftFrames = new GreenfootImage[8];
        walkRightFrames = new GreenfootImage[8];
        ataqueFrames1 = new GreenfootImage[5];
        ataqueFrames2 = new GreenfootImage[5];
        ataqueFrames3 = new GreenfootImage[6];

        // Inicialize as imagens dos frames

        idleFrames[0] = new GreenfootImage("pose1-removebg-preview.png");
        idleFrames[1] = new GreenfootImage("pose2-removebg-preview.png");
        idleFrames[2] = new GreenfootImage("pose3-removebg-preview.png");
        idleFrames[3] = new GreenfootImage("pose4-removebg-preview.png");

        jumpFrames[0] = new GreenfootImage("jump1-removebg-preview.png");
        jumpFrames[1] = new GreenfootImage("jump2-removebg-preview.png");
        jumpFrames[2] = new GreenfootImage("jump3-removebg-preview.png");
        jumpFrames[3] = new GreenfootImage("jump4-removebg-preview.png");
        jumpFrames[4] = new GreenfootImage("jump5-removebg-preview.png");
        jumpFrames[5] = new GreenfootImage("jump6-removebg-preview.png");

        walkLeftFrames[0] = new GreenfootImage("run1-Left.png");
        walkLeftFrames[1] = new GreenfootImage("run2-Left.png");
        walkLeftFrames[2] = new GreenfootImage("run3-Left.png");
        walkLeftFrames[3] = new GreenfootImage("run4-Left.png");
        walkLeftFrames[4] = new GreenfootImage("run5-Left.png");
        walkLeftFrames[5] = new GreenfootImage("run6-Left.png");
        walkLeftFrames[6] = new GreenfootImage("run7-Left.png");
        walkLeftFrames[7] = new GreenfootImage("run8-Left.png");

        walkRightFrames[0] = new GreenfootImage("run1-removebg-preview.png");
        walkRightFrames[1] = new GreenfootImage("run2-removebg-preview.png");
        walkRightFrames[2] = new GreenfootImage("run3-removebg-preview.png");
        walkRightFrames[3] = new GreenfootImage("run4-removebg-preview.png");
        walkRightFrames[4] = new GreenfootImage("run5-removebg-preview.png");
        walkRightFrames[5] = new GreenfootImage("run6-removebg-preview.png");
        walkRightFrames[6] = new GreenfootImage("run7-removebg-preview.png");
        walkRightFrames[7] = new GreenfootImage("run8-removebg-preview.png");

        ataqueFrames1[0] = new GreenfootImage("ataque1-1-removebg-preview.png");
        ataqueFrames1[1] = new GreenfootImage("ataque1-2-removebg-preview.png");
        ataqueFrames1[2] = new GreenfootImage("ataque1-3-removebg-preview.png");
        ataqueFrames1[3] = new GreenfootImage("ataque1-4-removebg-preview.png");
        ataqueFrames1[4] = new GreenfootImage("ataque1-5-removebg-preview.png");

        ataqueFrames2[0] = new GreenfootImage("ataque2-1-removebg-preview.png");
        ataqueFrames2[1] = new GreenfootImage("ataque2-2-removebg-preview.png");
        ataqueFrames2[2] = new GreenfootImage("ataque2-3-removebg-preview.png");
        ataqueFrames2[3] = new GreenfootImage("ataque2-4-removebg-preview.png");
        ataqueFrames2[4] = new GreenfootImage("ataque2-5-removebg-preview.png");

        ataqueFrames3[0] = new GreenfootImage("ataque3-1-removebg-preview.png");
        ataqueFrames3[1] = new GreenfootImage("ataque3-2-removebg-preview.png");
        ataqueFrames3[2] = new GreenfootImage("ataque3-3-removebg-preview.png");
        ataqueFrames3[3] = new GreenfootImage("ataque3-4-removebg-preview.png");
        ataqueFrames3[4] = new GreenfootImage("ataque3-5-removebg-preview.png");
        ataqueFrames3[5] = new GreenfootImage("ataque3-6-removebg-preview.png");

        currentFrames = idleFrames;
        currentFrame = 0;
        animationDelay = 0;

        moveSpeed = 3;
        vSpeed = 0;
        acceleration = 1;
        jumpStrength = 18;

        ataqueCount = 0; // Inicializa o contador de ataques realizados
    }

    public void act() {
        handleMovement();
        handleJump();
        updateAnimation();
        checkAttacks();
    }

    private void handleMovement() {
        int moveX = 0;

        if (Greenfoot.isKeyDown("left")) {
            moveX = -moveSpeed;
            currentFrames = walkLeftFrames;
        } else if (Greenfoot.isKeyDown("right")) {
            moveX = moveSpeed;
            currentFrames = walkRightFrames;
        } else {
            currentFrames = idleFrames;
        }

        setLocation(getX() + moveX, getY());
    }

    private void handleJump() {
        if (onGround()) {
            vSpeed = 0;

            if (Greenfoot.isKeyDown("up")) {
                vSpeed -= jumpStrength;
                currentFrames = jumpFrames;

                animationDelay = 0;
            }
        } else {
            vSpeed += acceleration;
        }

        setLocation(getX(), getY() + vSpeed);
    }

    private boolean onGround() {
        int groundHeight = getImage().getHeight() / 2;
        int groundOffset = 10; // Ajuste necessário para verificar a altura do chão corretamente

        Actor ground = getOneObjectAtOffset(0, groundHeight + groundOffset, chao.class);

        return ground != null;
    }

    private void updateAnimation() {
        if (animationDelay < 5) {
            animationDelay++;
            return;
        }

        animationDelay = 0;
        currentFrame = (currentFrame + 1) % currentFrames.length;

        setImage(currentFrames[currentFrame]);
    }

    private void checkAttacks() {
        if (Greenfoot.isKeyDown("space")) {
            ataqueCount++;

            if (ataqueCount == 1) {
                currentFrames = ataqueFrames1;
            } else if (ataqueCount == 2) {
                currentFrames = ataqueFrames2;
            } else if (ataqueCount == 3) {
                currentFrames = ataqueFrames3;
                ataqueCount = 0; // Reseta o contador de ataques para reiniciar o ciclo
            }
        }
    }
}
