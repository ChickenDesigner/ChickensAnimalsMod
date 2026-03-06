package chicken.creaturecorner.server.entity.obj.base;

public interface IEggLayer {

    boolean isPregnant();

    void setPregnant(boolean pregnant);

    int getLayEggCounter();

    void setLayEggCounter(int layEggCounter);

    boolean isLayingEgg();

    void setLayingEgg(boolean pregnant);

    void onEggLaid();
}
