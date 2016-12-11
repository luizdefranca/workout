package workout.hfad.com.workout.model;

/**
 * Created by luizramos on 10/12/16.
 */

public class Workout {

    private String name;
    private String description;


    public static final Workout[] worktouts = {
            new Workout("Supino", "Levantar peso sobre o peito enquanto deitado em uma mesa"),
            new Workout("Agachamento", "Se abaixar com um peso extra"),
            new Workout("Pull-over", "exercício que eu nao lembro a descricao")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
