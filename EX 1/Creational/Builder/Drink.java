public abstract class Drink implements Item {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}
