public class DieselLocomotive extends AbstractLocomotive{

    public DieselLocomotive(){
        super();
        DieselLocomotive.type = "Diesel";
    }

    public DieselLocomotive(int power, int maxSpeed){
        super(power, maxSpeed);
        DieselLocomotive.type = "Diesel";
    }
}
