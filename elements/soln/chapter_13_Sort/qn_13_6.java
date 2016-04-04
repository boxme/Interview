import java.util.*;

class qn_13_6 {

    public boolean checkIfTeamACanBePlacedInFrontOfB(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; ++i) {
            if (B[i] <= A[i]) {
                return false;
            }
        }

        return true;
    }
}
