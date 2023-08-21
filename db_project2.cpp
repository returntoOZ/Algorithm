#include "stdio.h"
#include "vector"
using namespace std;

struct Node{
    vector<pair<int,int>> leaf_b;
    vector<pair<int,Node*>> non_leaf_b;
    Node* next;
    bool is_leaf;
};

class BPlusTree {
private:
    Node* root;
    int blockSize;
    int order;
public:
    BPlusTree(int blockSize, int order){
        root = nullptr;
        this->blockSize = blockSize;
        this->order = order;
    }

    void insert(int key, int value){
        if(root == nullptr){
            root = new Node();
            root->leaf_b.push_back(make_pair(key, value));
            root->is_leaf = true;
        }else{
            Node* leaf = find_leaf(key);
            leaf->leaf_b.push_back(make_pair(key, value));

            if(leaf->leaf_b.size() > order -1){
                split_leaf(leaf);
            }
        }
    }

    void split_leaf(Node* leaf_node){
        Node* new_leaf = new Node();
        new_leaf->is_leaf = true;

        int idx =leaf_node->leaf_b.size()/2 + 1;

        for(int i=0; i<idx; i++){
            new_leaf->non_leaf_b.assign(leaf_node->non_leaf_b.begin() + idx, leaf_node->non_leaf_b.end());
            leaf_node->non_leaf_b.erase(leaf_node->non_leaf_b.begin() + idx, leaf_node->non_leaf_b.end());
        }


        new_leaf->non_leaf_b[new_leaf->non_leaf_b.size()-1]
    }

    Node* find_leaf(int key){
        Node* cur = root;

        while(!cur->is_leaf){
            for(int i=0; i<cur->non_leaf_b.size(); i++){
                if(key <= cur->non_leaf_b[i].first) {
                    cur = cur->non_leaf_b[i].second;
                    break;
                }
                if(i == cur->non_leaf_b.size()-1){
                    cur = cur->non_leaf_b[i].second->next;
                    break;
                }
            }
        }
        return cur;
    }

    Node* search(int key){
        Node* cur = root;

        if(root == nullptr)
            return nullptr;

        else{
            cur = find_leaf(key);

            for(int i=0; i<cur->leaf_b.size(); i++){
                if(cur->leaf_b[i].first == key)
                    return cur;
            }

            return nullptr;
        }
    };

    int range_search(int startRange, int endRange){
        int idx = 0;
        vector<int> result;
        Node* cur = search(startRange);
        int val = cur->leaf_b[0].first;

        while(val <= endRange){
            if(cur == nullptr)
                break;
            else{
                for(int i=0; i<cur->non_leaf_b.size(); i++){
                    val = cur->non_leaf_b[i].first;
                    if((val >= startRange) && (val <= endRange)){
                        result.push_back(val);
                        idx++;
                    }
                }
                cur = cur->non_leaf_b[cur->non_leaf_b.size()].second;
            }
        }

        return idx;
    };

    void print();
};
// Test
int main (int argc, char* argv[])
{
    char command = argv[1][0];
    BPlusTree myTree = new BPlusTree();
    switch(command)
    {
        case 'c' :
// create index file
            break;
        case 'i' :
// insert records from [records data file], ex) records.txt
            break;
        case 's' :
// search keys in [input file] and print results to [output file]
            break;
        case 'r' :
// search keys in [input file] and print results to [output file]
            break;
        case 'p' :
// print B+-Tree structure to [output file]
            break;
    }