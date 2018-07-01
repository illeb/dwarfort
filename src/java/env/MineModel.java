package env;

import java.util.ArrayList;

import jason.environment.grid.Area;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class MineModel extends GridWorldModel{
    // constants used by the view component (HouseView) to draw environment
    // "objects"
    public static final int GOLD = 16;
    public static final int STEEL = 32;
    public static final int BEER = 64;
	protected final static int GRIDSIZE=40;
	ArrayList<Cave> caves = new ArrayList<Cave>();

    protected MineModel() {
		super(GRIDSIZE, GRIDSIZE, 3);
		
		//setAgentsPositions();
		buildEnvironment();
    }
    
    public void setAgentsPositions() {
		this.setAgPos(0, new Location(1, 1));
    }
    
    private void buildEnvironment() {
    	buildWorld();
    	setItems();
    }
    private void buildWorld() {
    	// zona controllo
    	Area area = new Area(new Location(16, 18), new Location(24, 22));
    	this.addWall(area.tl.x, area.tl.y, area.tl.x+3, area.tl.y);  
    	this.addWall(area.tl.x+5, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	
    	// zona nordOvest
    	Cave cave = new Cave();
    	area = new Area(new Location(0, 0), new Location(10, 6));   
    	cave.areas.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x+6, area.br.y, area.br.x, area.br.y);  
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	area = new Area(new Location(0, 6), new Location(6, 10));
    	cave.areas.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);    	
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.tl.y+2);
    	this.addWall(area.br.x, area.tl.y+4, area.br.x, area.br.y);

    	this.addWall(area.br.x, area.tl.y+2, 19, area.tl.y+2);
    	Area tunnel = new Area(area.br.x, area.tl.y+3, 19, area.tl.y+3);
    	this.addWall(area.br.x, area.tl.y+4, 19, area.tl.y+4);
    	cave.tunnels.add(tunnel);    	
    	this.caves.add(cave);
    	
    	// zona nord
    	cave = new Cave();
    	area = new Area(new Location(14, 0), new Location(26, 6));   
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.tl.x+5, area.br.y);
    	this.addWall(area.tl.x+7, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	
    	this.addWall(area.tl.x+5, 6, area.tl.x+5, 8);
    	this.addWall(area.tl.x+5, 10, area.tl.x+5, 18);
    	tunnel = new Area(new Location(area.tl.x+6, 6), new Location(area.tl.x+6, 18));
    	this.addWall(area.tl.x+7, 6, area.tl.x+7, 18);
    	cave.tunnels.add(tunnel);    	
    	this.caves.add(cave);	

    	/*
    	//cunicolo nord-controllo
    	this.addWall(area.tl.x+5, area.br.y, area.tl.x+5, 18);    	
    	this.addWall(area.tl.x+7, area.br.y, area.tl.x+7, 18);
    	this.world.add(new Area(new Location(area.tl.x+6, 6), new Location(area.tl.x+6, 18)));
    	
    	// // zona Est
    	area = new Area(new Location(35, 8), new Location(39, 16));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	area = new Area(new Location(33, 16), new Location(39, 22));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	
    	
    	// // zona sudEst
    	area = new Area(new Location(26, 30), new Location(39, 39));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	
    	// // zona sud
    	area = new Area(new Location(18, 35), new Location(22, 39));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	area = new Area(new Location(12, 32), new Location(18, 39));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	
    	// // zona sudOvest
    	area = new Area(new Location(0, 34), new Location(8, 39));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);
    	
    	// // zona Ovest
    	area = new Area(new Location(0, 17), new Location(6, 23));
    	this.world.add(area);
    	this.addWall(area.tl.x, area.tl.y, area.br.x, area.tl.y);    	
    	this.addWall(area.tl.x, area.tl.y, area.tl.x, area.br.y);
    	this.addWall(area.tl.x, area.br.y, area.br.x, area.br.y);
    	this.addWall(area.br.x, area.tl.y, area.br.x, area.br.y);*/
    }
    private void setItems() {
    	this.add(GOLD, new Location(2,1));
    	this.add(GOLD, new Location(2,1));
    	this.add(GOLD, new Location(3,1));
    	this.add(GOLD, new Location(4,1));
    	this.add(GOLD, new Location(5,1));
    	
    	this.add(STEEL, new Location(1,4));
    	this.add(STEEL, new Location(1,5));    	
    }
    
    boolean moveTowards(final Location dest) {
        final Location r1 = this.getAgPos(0);
        // compute where to move
        if (r1.x < dest.x) {
            r1.x++;
        } else if (r1.x > dest.x) {
            r1.x--;
        }
        if (r1.y < dest.y) {
            r1.y++;
        } else if (r1.y > dest.y) {
            r1.y--;
        }
        this.setAgPos(0, r1); // actually move the robot in the grid
        // repaint fridge and owner locations (to repaint colors)
       /* if (this.view != null) {
            this.view.update(this.lFridge.x, this.lFridge.y);
            this.view.update(this.lOwner.x, this.lOwner.y);
        }*/
        return true;
    }
    
    public void move() {
    	this.setAgPos(0, new Location(5, 5));
    }
    
    public void scanArea() {
    	
    }
}
