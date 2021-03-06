package internseason.scheduler.algorithm;

/**
 * Enum that defines what algorithms can be built by the factory method.
 */
public enum AlgorithmType {
    A_STAR_ALGORITHM {
        @Override
        public BaseAlgorithm getInstance(){
            return new AStarAlgorithm();
        }
    },
    BASIC_ALGORITHM {
        @Override
        public BaseAlgorithm getInstance() {
            return new BasicAlgorithm();
        }
    },
    BRANCH_AND_BOUND_ALGORITHM {
        @Override
        public BaseAlgorithm getInstance() { return new BranchAndBoundAlgorithm();}
    };

    public abstract BaseAlgorithm getInstance();

}