public abstract class Burger implements Item {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}
