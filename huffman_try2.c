#include <stdio.h>
#include <string.h>

#define MAXN 26
#define MAXNODES (2 * MAXN)
#define MAXCODE 64

typedef struct {
    char ch;
    int freq;
    int left;
    int right;
    char min_ch;
    int is_leaf;
} Node;

static Node nodes[MAXNODES];
static int heap[MAXNODES];
static int heap_size = 0;
static char codes[26][MAXCODE];
static char input_chars[MAXN];

static int higher_priority(int a, int b) {
    if (nodes[a].freq != nodes[b].freq) return nodes[a].freq < nodes[b].freq;
    return nodes[a].min_ch < nodes[b].min_ch;
}

static void heap_swap(int i, int j) {
    int tmp = heap[i];
    heap[i] = heap[j];
    heap[j] = tmp;
}

static void heap_push(int idx) {
    int i = heap_size;
    heap[heap_size++] = idx;

    while (i > 0) {
        int p = (i - 1) / 2;
        if (!higher_priority(heap[i], heap[p])) break;
        heap_swap(i, p);
        i = p;
    }
}

static int heap_pop(void) {
    int top = heap[0];
    heap[0] = heap[--heap_size];

    int i = 0;
    while (1) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int best = i;

        if (l < heap_size && higher_priority(heap[l], heap[best])) best = l;
        if (r < heap_size && higher_priority(heap[r], heap[best])) best = r;

        if (best == i) break;
        heap_swap(i, best);
        i = best;
    }

    return top;
}

static void build_codes(int idx, char path[], int depth) {
    if (nodes[idx].is_leaf) {
        if (depth == 0) {
            path[0] = '0';
            depth = 1;
        }
        path[depth] = '\0';
        strcpy(codes[nodes[idx].ch - 'a'], path);
        return;
    }

    path[depth] = '0';
    build_codes(nodes[idx].left, path, depth + 1);

    path[depth] = '1';
    build_codes(nodes[idx].right, path, depth + 1);
}

int main(void) {
    int n;
    if (scanf("%d", &n) != 1) return 0;

    int node_count = 0;
    memset(codes, 0, sizeof(codes));

    for (int i = 0; i < n; i++) {
        char c;
        int f;
        scanf(" %c %d", &c, &f);

        input_chars[i] = c;

        nodes[node_count].ch = c;
        nodes[node_count].freq = f;
        nodes[node_count].left = -1;
        nodes[node_count].right = -1;
        nodes[node_count].min_ch = c;
        nodes[node_count].is_leaf = 1;

        heap_push(node_count);
        node_count++;
    }

    while (heap_size > 1) {
        int left = heap_pop();
        int right = heap_pop();

        nodes[node_count].ch = '#';
        nodes[node_count].freq = nodes[left].freq + nodes[right].freq;
        nodes[node_count].left = left;
        nodes[node_count].right = right;
        nodes[node_count].min_ch = (nodes[left].min_ch < nodes[right].min_ch)
                                  ? nodes[left].min_ch
                                  : nodes[right].min_ch;
        nodes[node_count].is_leaf = 0;

        heap_push(node_count);
        node_count++;
    }

    int root = heap_pop();
    char path[MAXCODE];
    build_codes(root, path, 0);

    for (int i = 0; i < n; i++) {
        printf("%c: %s\n", input_chars[i], codes[input_chars[i] - 'a']);
    }

    return 0;
}
