# DFS
Depth-first search (DFS) is a straightforward graph traversal technique. The algorithm begins at a starting node, and proceeds to all other nodes that are reachable from the starting node using the edges of the graph.
Depth-first search always follows a single path in the graph as long as it finds new nodes. After this, it returns to previous nodes and begins to explore other parts of the graph. The algorithm keeps track of visited nodes, so that it processes each node only once.

![](imgs/dfs.jpg)

The **time complexity** of depth-first search is `O(n + m)` where n is the number of nodes and m is the number of edges, because the algorithm processes each node and edge once.