package edu.umsl;

interface HydraBody {
    void hydraHeads();
    void hydraTails();
}

class Hydra implements HydraBody {
    @Override
    public void hydraHeads() {
        System.out.println("Set the number of heads on your Hydra:");
    }
    @Override
    public void hydraTails() {
        System.out.println("Set the number of tails on your Hydra:");
    }
}