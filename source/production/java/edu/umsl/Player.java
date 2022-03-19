package edu.umsl;

interface Player {
    void Move1();
    void Move2();
    void Move3();
    void Move4();
    void MovesAvailable();
    void SelectMove();
}
class playerMoves implements Player {
    @Override
    public void Move1() {
        System.out.println("Move 1 - Cut off 1 head.");
    }
    @Override
    public void Move2() {
        System.out.println("Move 2 - Cut off 1 tail.");
    }
    @Override
    public void Move3() {
        System.out.println("Move 3 - Cut off 2 heads.");
    }
    @Override
    public void Move4() {
        System.out.println("Move 4 - Cut off 2 tails.");
    }
    @Override
    public void MovesAvailable() {
        System.out.println("The following moves are available to slay the Hydra:");
    }
    @Override
    public void SelectMove() {
        System.out.println("Please select a move:");
    }
}

