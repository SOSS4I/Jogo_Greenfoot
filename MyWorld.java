import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        chao chao = new chao();
        addObject(chao,694,778);

        chao.setLocation(853,803);

        chao.setLocation(979,905);
        chao.setLocation(957,760);
        chao.setLocation(948,698);
        chao.setLocation(947,755);
        chao.setLocation(935,714);
        chao.setLocation(995,683);

        chao.setLocation(222,892);
        chao chao2 = new chao();
        addObject(chao2,787,869);
        chao2.setLocation(798,892);
        chao chao3 = new chao();
        addObject(chao3,1347,858);
        chao3.setLocation(1379,892);
        Link link = new Link();
        addObject(link,500,645);
        Link2 link2 = new Link2();
        addObject(link2,1091,542);
        link2.setLocation(1012,725);
        link2.setLocation(994,749);
        removeObject(link);
        link2.setLocation(1005,771);
        link2.setLocation(143,745);
        link2.setLocation(133,736);
        link2.setLocation(148,755);
    }
}
