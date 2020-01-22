package model;

import java.util.ArrayList;

class FindPath {

    public static boolean isPath(int matrix[][])
    {
        //tableau des cases djà visitées
        boolean visited[][] = new boolean[8][8];

        boolean is_path=false;

        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(matrix[i][j]==1 && !visited[i][j]) {
                    //on cherche un chemin à partir de la position i,j
                    if (isPath(matrix, i, j, visited)) {
                        is_path = true;
                        break; //on sort de la boucle dès qu'on trouve un chemin
                    }
                }
            }
        }
        //si la boucle se termine c'est qu'on a pas trouvé de chemin
        return is_path;
    }


    //vérifie qu'on ne sort pas du plateau
    public static boolean isInBoard(int i, int j, int matrix[][])
    {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    //renvoie vrai si il y a un chemin d'une source à une destination
    public static boolean isPath(int matrix[][], int i, int j, boolean visited[][]){

        //vérifie que la position est dans le plateau, que ce n'est pas un mur et qu'elle n'est pas visitée
        if(isInBoard(i, j, matrix) && matrix[i][j]!=3 && !visited[i][j]) {
            visited[i][j]=true; //on visite la case
            if(matrix[i][j]==2) {return true;} //si c'est la destination on a trouvé un chemin

            //on cherche des chemins dans les 4 directions

            if(isPath(matrix, i-1, j, visited))
                return true;

            if(isPath(matrix, i, j-1, visited))
                return true;

            if(isPath(matrix, i+1, j, visited))
                return true;

            if(isPath(matrix, i, j+1, visited))
                return true;
        }
        return false; //aucun chemin n'a été trouvé
    }

    public static int[][] change_format(ArrayList<Piece> pieces_list) {
        int[][] tab = new int[8][8];
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                tab[i][j]=0;
            }
        }
        for(Piece piece:pieces_list) {
            if (!piece.getIs_destructible()) {
                Position position = piece.getPosition();
                tab[position.getX()][position.getY()]=3;
            }
        }
        return tab;
    }
}