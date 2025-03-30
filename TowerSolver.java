public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
        // Nothing to do here
    }

    public void solve(TowerModel model) {
        this.model = model;
        solve(model.height(), 0, 2, 1); // Move all disks from tower 0 to tower 2 using tower 1 as auxiliary
    }

    // Recursive method to solve Towers of Hanoi
    private void solve(int n, int source, int destination, int auxiliary) {
        if (n == 1) {
            model.move(source, destination); // Base case: Move a single disk
            model.print(); // Print state after move
            return;
        }

        // Move n-1 disks from source to auxiliary using destination as a buffer
        solve(n - 1, source, auxiliary, destination);

        // Move the nth (largest) disk from source to destination
        model.move(source, destination);
        model.print(); // Print state after move

        // Move n-1 disks from auxiliary to destination using source as a buffer
        solve(n - 1, auxiliary, destination, source);
    }
}
