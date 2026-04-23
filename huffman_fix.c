#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXN 26
#define MAXNODES (2 * MAXN)
#define MAXCODE 64

typedef struct {
    char ch;
    int freq;
    int left;
    int right;
    int minChar;
    int isLeaf;
} Node;

Node nodes[MAXNODES];
int heap[MAXNODES];
int heapSize = 0;
char codes[26][MAXCODE];
int present[26];

int higherPriority(int a, int b) {
    if (nodes[a].freq != nodes[b].freq) return nodes[a].freq < nodes[b].freq;
    if (nodes[a].isLeaf != nodes[b].isLeaf) return nodes[a].isLeaf > nodes[b].isLeaf;
    return nodes[a].minChar < nodes[b].minChar;
}

void heapSwap(int i, int j) {
    int t = heap[i];
    heap[i] = heap[j];
    heap[j] = t;
}

void heapPush(int idx) {
    int i = heapSize++;
    heap[i] = idx;
    while (i > 0) {
        int p = (i - 1) / 2;
        if (higherPriority(heap[i], heap[p])) {
            heapSwap(i, p);
            i = p;
        } else {
            break;
        }
    }
}

int heapPop(void) {
    int top = heap[0];
    heap[0] = heap[--heapSize];

    int i = 0;
    while (1) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int best = i;

        if (l < heapSize && higherPriority(heap[l], heap[best])) best = l;
        if (r < heapSize && higherPriority(heap[r], heap[best])) best = r;

        if (best != i) {
            heapSwap(i, best);
            i = best;
        } else {
            break;
        }
    }

    return top;
}

void generateCodes(int idx, char path[], int depth) {
    if (nodes[idx].isLeaf) {
        if (depth == 0) {
            path[0] = '0';
            depth = 1;
        }
        path[depth] = '\0';
        strcpy(codes[nodes[idx].ch - 'a'], path);
        return;
    }

    path[depth] = '0';
    generateCodes(nodes[idx].left, path, depth + 1);

    path[depth] = '1';
    generateCodes(nodes[idx].right, path, depth + 1);
}

int main(void) {
    int n;
    if (scanf("%d", &n) != 1) return 0;

    int nodeCount = 0;
    memset(codes, 0, sizeof(codes));
    memset(present, 0, sizeof(present));

    for (int i = 0; i < n; i++) {
        char c;
        int f;
        scanf(" %c %d", &c, &f);

        nodes[nodeCount].ch = c;
        nodes[nodeCount].freq = f;
        nodes[nodeCount].left = -1;
        nodes[nodeCount].right = -1;
        nodes[nodeCount].minChar = c;
        nodes[nodeCount].isLeaf = 1;

        present[c - 'a'] = 1;
        heapPush(nodeCount);
        nodeCount++;
    }

    while (heapSize > 1) {
        int a = heapPop();
        int b = heapPop();

        int left = a;
        int right = b;
        if (higherPriority(b, a)) {
            left = b;
            right = a;
        }

        nodes[nodeCount].ch = '{';
        nodes[nodeCount].freq = nodes[left].freq + nodes[right].freq;
        nodes[nodeCount].left = left;
        nodes[nodeCount].right = right;
        nodes[nodeCount].minChar = nodes[left].minChar < nodes[right].minChar ? nodes[left].minChar : nodes[right].minChar;
        nodes[nodeCount].isLeaf = 0;

        heapPush(nodeCount);
        nodeCount++;
    }

    int root = heapPop();
    char path[MAXCODE];
    generateCodes(root, path, 0);

    for (int i = 0; i < 26; i++) {
        if (present[i]) {
            printf("%c: %s\n", (char)('a' + i), codes[i]);
        }
    }

    return 0;
}
