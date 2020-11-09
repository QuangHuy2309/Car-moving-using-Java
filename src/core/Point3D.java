package core;

public class Point3D {
    private int x,y,z;

    public Point3D(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public Point3D(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3D(Point3D A){
        this.x = A.getX();
        this.y = A.getY();
        this.z = A.getZ();
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getZ(){
        return this.z;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setZ(int z){
        this.z = z;
    }
}
