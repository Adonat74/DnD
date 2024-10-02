package game.board.cell;

// Class Cell Générique ayant un type parametré T
public class Cell<T> {
    public T entity = null;

    public void setEntity(T entity) {
        this.entity = entity;
    }
    public T getEntity(){
        return entity;
    }

}
