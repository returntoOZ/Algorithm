#include <iostream>
#include <utility>
#include <stack>

using namespace std;

class node {
private:

public:
    node* parent_;
    node* left_child_;
    node* right_child_;
    int data_;
    int height_;
    int rank_;

    node() { // 기본 생성자
      parent_ = nullptr;
      left_child_ = nullptr;
      right_child_ = nullptr;
      data_ = -1;
      height_ = -1;
      rank_ = -1;
    }
    node(int data) { // key값만 받는 생성자
      parent_ = nullptr;
      left_child_ = nullptr;
      right_child_ = nullptr;
      data_ = data;
      height_ = 1;
      rank_ = 1;
    }
    node(int data, node* parent) { // key
      parent_ = parent;
      left_child_ = nullptr;
      right_child_ = nullptr;
      data_ = data;
      height_ = 1;
      rank_ = 1;
    }
    ~node() {}

};

class set {
private:
    int size_;

public:
    node* root;

    set() {
      size_ = 0;
      root = nullptr;
    }
    ~set() {

    }

    pair<node*, int> SearchNode(node* root, int key, int depth) {

      if (root == nullptr || root->data_ == key) return { root, depth };

      else if (root->data_ > key) {
        return SearchNode(root->left_child_, key, depth + 1);
      }

      else {
        return SearchNode(root->right_child_, key, depth + 1);
      }
    }

    int GetBalanceFactor(node* root) {
      int left_height = (root->left_child_) ? root->left_child_->height_ : 0;
      int right_height = (root->right_child_) ? root->right_child_->height_ : 0;

      return left_height - right_height;
    }

    void ReBalanceNode(node* cur_node, int key) {
      int balance_factor = GetBalanceFactor(cur_node);

      if (balance_factor > 1) { // left height가 더 큰 경우
        if (GetBalanceFactor(cur_node->left_child_) >= 0) {
          // Right Rotation case
          cur_node = RightRotation(cur_node);
        }
        else {
          // Left-Right Rotation case
          cur_node->left_child_ = LeftRotation(cur_node->left_child_);
          cur_node = RightRotation(cur_node);
        }
      }
      else if (balance_factor < -1) {
        if (GetBalanceFactor(cur_node->right_child_) <= 0) {
          // Left Rotation case
          cur_node = LeftRotation(cur_node);
        }
        else {
          // Right-Left Rotation case
          cur_node->right_child_ = RightRotation(cur_node->right_child_);
          cur_node = LeftRotation(cur_node);
        }
      }

      // 회전 이후에도 높이 업데이트
      cur_node->height_ = 1 + max((cur_node->left_child_ ? cur_node->left_child_->height_ : 0),
                                  (cur_node->right_child_ ? cur_node->right_child_->height_ : 0));
      cur_node->rank_ = GetRank(cur_node->left_child_) + GetRank(cur_node->right_child_) + 1;
    }


    node* RightRotation(node* root) {
      node* new_root = root->left_child_;
      node* change_left_child = new_root->right_child_;

      if (root == this->root) {
        this->root = new_root;
        new_root->parent_ = nullptr;
      }
      else {
        if (root->parent_->left_child_ == root) root->parent_->left_child_ = new_root;
        else root->parent_->right_child_ = new_root;
        new_root->parent_ = root->parent_;
      }

      root->left_child_ = change_left_child;
      if (change_left_child != nullptr) change_left_child->parent_ = root;
      root->parent_ = new_root;
      new_root->right_child_ = root;

      root->height_ = max((root->left_child_ ? root->left_child_->height_ : 0),
                          (root->right_child_ ? root->right_child_->height_ : 0)) + 1;
      new_root->height_ = max((new_root->left_child_ ? new_root->left_child_->height_ : 0),
                              (new_root->right_child_ ? new_root->right_child_->height_ : 0)) + 1;
      root->rank_ = GetRank(root->left_child_) + GetRank(root->right_child_) + 1;
      new_root->rank_ = GetRank(new_root->left_child_) + GetRank(new_root->right_child_) + 1;
      return new_root;
    }

    node* LeftRotation(node* root) {
      node* new_root = root->right_child_;
      node* change_right_child = new_root->left_child_;

      if (root == this->root) {
        this->root = new_root;
        new_root->parent_ = nullptr;
      }
      else {
        if (root->parent_->left_child_ == root) root->parent_->left_child_ = new_root;
        else root->parent_->right_child_ = new_root;
        new_root->parent_ = root->parent_;
      }

      root->right_child_ = change_right_child;
      if (change_right_child != nullptr) change_right_child->parent_ = root;
      root->parent_ = new_root;
      new_root->left_child_ = root;

      root->height_ = max((root->left_child_ ? root->left_child_->height_ : 0),
                          (root->right_child_ ? root->right_child_->height_ : 0)) + 1;
      new_root->height_ = max((new_root->left_child_ ? new_root->left_child_->height_ : 0),
                              (new_root->right_child_ ? new_root->right_child_->height_ : 0)) + 1;
      root->rank_ = GetRank(root->left_child_) + GetRank(root->right_child_) + 1;
      new_root->rank_ = GetRank(new_root->left_child_) + GetRank(new_root->right_child_) + 1;

      return new_root;
    }

    void FindMaximum(node* root, int depth) {
      if (root->right_child_ == nullptr)
      {
        cout << root->data_ << " " << depth << "\n";
      }
      else
      {
        return FindMaximum(root->right_child_, depth + 1);
      }
    }

    void FindMinimum(node* root, int depth) {
      if (root->left_child_ == nullptr)
      {
        cout << root->data_ << " " << depth << "\n";
      }
      else
      {
        FindMinimum(root->left_child_, depth + 1);
      }

    }

    node* FindMinimum(node* root) {
      if (root->left_child_ == nullptr)
      {
        return root;
      }
      else
      {
        return FindMinimum(root->left_child_);
      }
    }

    int get_size() {
      return size_;
    }

    bool isempty() {
      if (size_) return false;
      return true;
    }

    node* InsertNode(node* cur_node, int key, int depth) {
      // 트리가 비어있는 경우
      if (isempty()) {
        node* root_node = new node(key);
        this->root = root_node;
        size_++;
        return root_node;
      }

      // cur_node가 nullptr인 경우 새로운 노드를 생성하여 반환
      if (cur_node == nullptr) {
        node* new_node = new node(key);
        size_++;
        return new_node;
      }

      node* new_node;

      // 현재 노드의 키와 비교하여 재귀적으로 적절한 위치에 노드 삽입
      if (cur_node->data_ > key) {
        if (cur_node->left_child_ != nullptr) {
          new_node = InsertNode(cur_node->left_child_, key, depth + 1);
        }
        else {
          new_node = new node(key, cur_node);
          cur_node->left_child_ = new_node;
          size_++;
        }
      }
      else {
        if (cur_node->right_child_ != nullptr) {
          new_node = InsertNode(cur_node->right_child_, key, depth + 1);
        }
        else {
          new_node = new node(key, cur_node);
          cur_node->right_child_ = new_node;
          size_++;
        }
      }

      // 현재 노드의 높이 업데이트
      cur_node->height_ = max((cur_node->left_child_ ? cur_node->left_child_->height_ : 0),
                              (cur_node->right_child_ ? cur_node->right_child_->height_ : 0)) + 1;
      cur_node->rank_ = GetRank(cur_node->left_child_) + GetRank(cur_node->right_child_) + 1;

      // 트리 리밸런싱
      ReBalanceNode(cur_node, key);

      return new_node;
    }

    int GetRank(node* cur_node) {
      return (cur_node == nullptr) ? 0 : cur_node->rank_;
    }

    int FindRankNode(node* cur_node, int key) {
      if (cur_node == nullptr) {
        return 0;
      }
      if (cur_node->data_ > key) {
        return FindRankNode(cur_node->left_child_, key);
      }
      else if (cur_node->data_ < key) {
        return FindRankNode(cur_node->right_child_, key) + GetRank(cur_node->left_child_) + 1;
      }
      else {
        return GetRank(cur_node->left_child_) + 1;
      }
    }

    void DeleteNode(node* cur_node, int key)
    {
      //erase에서 x의 두 자식이 모두 내부노드인 경우 후임자를 이용하여 삭제 수행
      //후임자: 해당 노드보다 값이 큰 노드 중 가장 값이 작은 노드

      if (key < cur_node->data_)
      {
        DeleteNode(cur_node->left_child_, key);
      }
      else if (key > cur_node->data_)
      {
        DeleteNode(cur_node->right_child_, key);
      }
        //현재 node가 삭제할 노드일 때
      else
      {
        node* parent_node = cur_node->parent_;
        node* replace_node = nullptr;

        //자식 노드가 없거나 하나인 경우
        if (cur_node->left_child_ == nullptr || cur_node->right_child_ == nullptr)
        {
          //오른쪽 자식만 존재하는 경우
          if (cur_node->left_child_ == nullptr)
          {
            replace_node = cur_node->right_child_;
          }
            //왼쪽 자식만 존재하는 경우
          else if (cur_node->right_child_ == nullptr)
          {
            replace_node = cur_node->left_child_;
          }
          size_--;

          //reference update
          if (parent_node == nullptr)
          {
            root = replace_node;
          }
          else
          {
            if (parent_node->left_child_ == cur_node)
              parent_node->left_child_ = replace_node;
            else
              parent_node->right_child_ = replace_node;
          }
          if (replace_node != nullptr)
            replace_node->parent_ = parent_node;

          node* tmp = cur_node;
          cur_node = replace_node;
          delete tmp;
        }
          //자식 노드가 둘인 경우
        else
        {
          //후임자(successor) 결정
          replace_node = FindMinimum(cur_node->right_child_);
          cur_node->data_ = replace_node->data_;
          DeleteNode(cur_node->right_child_, replace_node->data_);
        }
      }

      if (cur_node == nullptr)
        return;

      ReBalanceNode(cur_node, cur_node->data_);
    }
};

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0); cout.tie(0);
  //avl_set test
  int testCase;
  cin >> testCase;

  while (testCase--) {
    int commandNum;
    cin >> commandNum;

    set my_set;

    for (int i = 0; i < commandNum; i++) {
      string command;
      cin >> command;

      if (command == "minimum") {
        int x;
        cin >> x;
        pair<node*, int> tmp = my_set.SearchNode(my_set.root, x, 0);
        if (tmp.first == nullptr) {

        }
        else {
          my_set.FindMinimum(tmp.first, tmp.second);
        }
      }
      else if (command == "maximum") {
        int x;
        cin >> x;
        pair<node*, int> tmp = my_set.SearchNode(my_set.root, x, 0);
        my_set.FindMaximum(tmp.first, tmp.second);
      }
      else if (command == "empty") {
        if (my_set.isempty()) cout << 1 << "\n";
        else cout << 0 << "\n";
      }
      else if (command == "size") {
        cout << my_set.get_size() << "\n";
      }
      else if (command == "find") {
        int x;
        cin >> x;
        pair<node*, int> tmp = my_set.SearchNode(my_set.root, x, 0);
        if (tmp.first == nullptr) cout << 0 << "\n";
        else cout << tmp.second << "\n";
      }
      else if (command == "insert") {
        int x;
        cin >> x;
        my_set.InsertNode(my_set.root, x, 0);
        pair<node*, int> insert_result = my_set.SearchNode(my_set.root, x, 0);
        cout << insert_result.second << "\n";
      }
      else if (command == "rank") {
        int x;
        cin >> x;
        pair<node*, int> rank_result = my_set.SearchNode(my_set.root, x, 0);
        if (rank_result.first == nullptr) {
          cout << 0 << "\n";
        }
        else {
          cout << rank_result.second << " " << my_set.FindRankNode(my_set.root, x) << "\n";
        }
      }
      else if (command == "erase") {
        int x;
        cin >> x;
        pair<node*, int> delete_result = my_set.SearchNode(my_set.root, x, 0);
        if (delete_result.first == nullptr) {
          cout << 0 << "\n";
        }
        else {
          my_set.DeleteNode(my_set.root, x);
          cout << delete_result.second << "\n";
        }
      }
      else {
        //error
      }
    }

  }
}

/*
5
44
insert 86
insert 15
insert 80
erase 80
erase 86
empty
insert 94
insert 13
size
find 13
insert 11
erase 11
insert 45
insert 91
insert 9
rank 94
empty
size
find 22
erase 94
insert 70
erase 15
size
rank 9
insert 46
maximum 46
size
find 46
erase 45
erase 46
insert 22
insert 46
erase 70
maximum 9
rank 46
minimum 22
insert 45
insert 12
empty
rank 45
maximum 91
maximum 22
rank 12
erase 46
16
insert 16
insert 73
minimum 16
insert 62
rank 16
insert 72
insert 41
insert 77
insert 2
insert 100
size
insert 43
insert 61
erase 77
insert 36
maximum 73
31
insert 61
rank 84
insert 14
insert 88
empty
erase 61
insert 90
rank 3
insert 98
rank 88
erase 14
insert 1
empty
insert 82
insert 76
find 76
erase 76
insert 34
rank 1
erase 98
insert 7
rank 90
insert 39
minimum 90
insert 77
find 71
insert 83
rank 39
size
minimum 82
rank 34
34
insert 27
insert 35
insert 44
minimum 44
erase 27
insert 71
insert 100
erase 71
rank 100
insert 30
rank 30
insert 1
size
maximum 100
erase 1
insert 18
insert 25
maximum 25
insert 89
erase 35
insert 58
insert 72
erase 44
insert 31
erase 89
empty
empty
erase 30
find 58
rank 58
erase 58
insert 77
insert 61
size
29
insert 54
insert 93
erase 54
insert 14
insert 77
empty
insert 70
insert 90
erase 77
erase 90
size
maximum 93
insert 12
insert 74
insert 98
insert 49
insert 78
find 70
insert 54
minimum 49
erase 49
erase 70
erase 78
maximum 54
empty
erase 93
size
minimum 98
find 74

1
31
insert 61
insert 14
insert 88
erase 61
insert 90
insert 98
erase 14

 */