package FirstAttempt;

public class RectangleArea {

	// http://www.programcreek.com/2014/06/leetcode-rectangle-area-java/
	/**
	 * On the x-axis, there are (A,C) and (E,G); on the y-axis, there are (F,H) and (B,D). 
	 * If they do not have overlap, the total area is the sum of 2 rectangle areas. 
	 * If they have overlap, the total area should minus the overlap area.
	 * */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A || B > H || D < F) {
        	return (G-E)*(H-F) + (C-A)*(D-B);
        }
        
        int left = Math.max(A, E);  ///// max
        int right = Math.min(C, G); ///// min
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        
        return (G-E)*(H-F) + (C-A)*(D-B) - (right - left) * (top - bottom);
    }
}
