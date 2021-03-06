
//! 左单旋转
#define RR rotateLeft
/*.........................................→.........................................*
 *....................A....................→....................C....................*
 *.................../.\...................→.................../.\...................*
 *................../...\..................→................../...\..................*
 *................./.....\.................→................./.....\.................*
 *................/.......\................→................/.......\................*
 *.............../.........\...............→.............../.........\...............*
 *............../...........\..............→............../...........\..............*
 *............./.............\.............→............./.............\.............*
 *............B..............(C)...........→............A...............G............*
 *.........................../.\...........→.........../.\............./.............*
 *........................../...\..........→........../...\.........../..............*
 *........................./.....\.........→........./.....\........./...............*
 *........................F.......G........→........B.......F.......N................*
 *.............................../.........→.........................................*
 *.............................[N].........→.........................................*
 *.........................................→.........................................*/

//! 右单旋转
#define LL rotateRight
/*.........................................→.........................................*
 *....................A....................→....................B....................*
 *.................../.\...................→.................../.\...................*
 *................../...\..................→................../...\..................*
 *................./.....\.................→................./.....\.................*
 *................/.......\................→................/.......\................*
 *.............../.........\...............→.............../.........\...............*
 *............../...........\..............→............../...........\..............*
 *............./.............\.............→............./.............\.............*
 *...........(B)..............C............→............D...............A............*
 *.........../.\...........................→.........../.............../.\...........*
 *........../...\..........................→........../.............../...\..........*
 *........./.....\.........................→........./.............../.....\.........*
 *........D.......E........................→........H...............E.......C........*
 *......./.................................→.........................................*
 *.....[H].................................→.........................................*
 *.........................................→.........................................*/

//! 左右双旋
#define LR(t, n) rotateLeft(t, n); rotateRight(t, n)
/*.........................................→.........................................→.........................................*
 *....................A....................→....................A....................→....................E....................*
 *.................../.\...................→.................../.\...................→.................../.\...................*
 *................../...\..................→................../...\..................→................../...\..................*
 *................./.....\.................→................./.....\.................→................./.....\.................*
 *................/.......\................→................/.......\................→................/.......\................*
 *.............../.........\...............→.............../.........\...............→.............../.........\...............*
 *............../...........\..............→............../...........\..............→............../...........\..............*
 *............./.............\.............→............./.............\.............→............./.............\.............*
 *............B...............C............→...........(E)..............C............→............B...............A............*
 *.........../.\...........................→.........../.\...........................→.........../.............../.\...........*
 *........../...\..........................→........../...\..........................→........../.............../...\..........*
 *........./.....\.........................→........./.....\.........................→........./.............../.....\.........*
 *........D......(E).......................→........B.......K........................→........D...............K.......C........*
 *.................\.......................→......./.................................→.........................................*
 *.................[K].....................→.....[D].................................→.........................................*
 *.........................................→.........................................→.........................................*/

//! 右左双旋
#define RL(t, n) rotateRight(t, n); rotateLeft(t, n)
/*.........................................→.........................................→.........................................*
 *....................A....................→....................A....................→....................F....................*
 *.................../.\...................→.................../.\...................→.................../.\...................*
 *................../...\..................→................../...\..................→................../...\..................*
 *................./.....\.................→................./.....\.................→................./.....\.................*
 *................/.......\................→................/.......\................→................/.......\................*
 *.............../.........\...............→.............../.........\...............→.............../.........\...............*
 *............../...........\..............→............../...........\..............→............../...........\..............*
 *............./.............\.............→............./.............\.............→............./.............\.............*
 *............B...............C............→............B..............(F)...........→............A...............C............*
 *.........................../.\...........→.........................../.\...........→.........../.\...............\...........*
 *........................../...\..........→........................../...\..........→........../...\...............\..........*
 *........................./.....\.........→........................./.....\.........→........./.....\...............\.........*
 *.......................(F)......G........→........................L.......C........→........B.......L...............G........*
 *......................./.................→.................................\.......→.........................................*
 *.....................[L].................→.................................[G].....→.........................................*
 *.........................................→.........................................→.........................................*/

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

#define GetParent(n)        (n->parent)
#define BindRoot(t, n)      t->root  = n;  if(n)   n->parent = NULL
#define BindLeft(n, nl)     n->left  = nl; if(nl) nl->parent = n
#define BindRight(n, nr)    n->right = nr; if(nr) nr->parent = n

static void rotateLeft(struct RBTree* tree, struct RBTNode* node) {
    struct RBTNode* childR = node->right;
    struct RBTNode* parent = GetParent(node);
    if( NULL == parent ) {
        BindRoot(tree, childR);
    } else {
        if(parent->left == node) {
            BindLeft(parent, childR);
        } else {
            BindRight(parent, childR);
        }
    }
    BindRight(node, childR->left);
    BindLeft(childR, node);
}

static void rotateRight(struct RBTree* tree, struct RBTNode* node) {
    struct RBTNode* childL = node->left;
    struct RBTNode* parent = GetParent(node);
    if( NULL == parent ) {
        BindRoot(tree, childL);
    } else {
        if(parent->left == node) {
            BindLeft(parent, childL);
        } else {
            BindRight(parent, childL);
        }
    }
    BindLeft(node, childL->right);
    BindRight(childL, node);
}