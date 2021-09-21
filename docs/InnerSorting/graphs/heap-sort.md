
#### ArrayToHeap

- $\textnormal{\footnotesize 左子序} = \textnormal{\footnotesize 父序} × 2 + 1$
- $\textnormal{\footnotesize 右子序} = \textnormal{\footnotesize 父序} × 2 + 2$
- <span style="color: #CC9933">非叶序区间：$\big[0, L / 2 - 1]$</span>
- <span style="color: #99FF99">叶子序区间：$\big[L / 2, L - 1\big]$</span>

```c
int A[] = {?, ?, ?, ?, ?, ?, ?, ?};
//    I = {0, 1, 2, 3, 4, 5, 6, 7};
//    L = 8;
```

```mermaid
graph TB
    style A0 fill:#CC9933;
    style A1 fill:#CC9933;
    style A2 fill:#CC9933;
    style A3 fill:#CC9933;
    style A4 fill:#99FF99;
    style A5 fill:#99FF99;
    style A6 fill:#99FF99;
    style A7 fill:#99FF99;

    style NIL_A3_R color:white,stroke:#aaa,fill:#aaa;
    style NIL_A4_L color:white,stroke:#aaa,fill:#aaa;
    style NIL_A4_R color:white,stroke:#aaa,fill:#aaa;
    style NIL_A5_L color:white,stroke:#aaa,fill:#aaa;
    style NIL_A5_R color:white,stroke:#aaa,fill:#aaa;
    style NIL_A6_L color:white,stroke:#aaa,fill:#aaa;
    style NIL_A6_R color:white,stroke:#aaa,fill:#aaa;

    A0(("A[0]"));
    A1(("A[1]"));
    A2(("A[2]"));
    A3(("A[3]"));
    A4(("A[4]"));
    A5(("A[5]"));
    A6(("A[6]"));
    A7(("A[7]"));

    A0---A1; A0---A2;
    A1---A3; A1---A4;
    A2---A5; A2---A6;
    A3---A7; A3---NIL_A3_R(("NIL"));
    A4---NIL_A4_L(("NIL")); A4---NIL_A4_R(("NIL"));
    A5---NIL_A5_L(("NIL")); A5---NIL_A5_R(("NIL"));
    A6---NIL_A6_L(("NIL")); A6---NIL_A6_R(("NIL"));
```

#### HeapAdjust

```c
int A[] = {49, 38, 13, 49, 76, 65, 27, 97};
// 构建大顶堆后
int R[] = {97, 76, 65, 49, 49, 13, 27, 38};
```

- <span style='color: yellow'>当前调整节点</span>、<span style='color: orange'>被传递调整的节点</span>、<span style='color: pink'>栈顶最值</span>、<span style='color: lightgreen'>取代栈顶的元素</span>、<span style='color: red'>冻结</span>

```mermaid
graph TD
    subgraph 2
        style 2 stroke:#333,stroke-width:2px,fill:grey;
        style B2 fill:yellow;
        style D2 fill:orange;
        A2((49));
        B2((38));
        C2((65));
        D2((97));
        E2((76));
        F2((13));
        G2((27));
        H2((49));
        A2---B2; A2---C2;
        B2-.-D2; B2---E2;
        C2---F2; C2---G2;
        D2-.-H2;
    end
    subgraph 1
        style 1 stroke:#333,stroke-width:2px,fill:grey;
        style C1 fill:yellow;
        A1((49));
        B1((38));
        C1((13));
        D1((97));
        E1((76));
        F1((65));
        G1((27));
        H1((49));
        A1---B1; A1---C1;
        B1---D1; B1---E1;
        C1-.-F1; C1---G1;
        D1---H1;
    end
    subgraph 0
        style 0 stroke:#333,stroke-width:2px,fill:grey;
        style D0 fill:yellow;
        A0((49));
        B0((38));
        C0((13));
        D0((49));
        E0((76));
        F0((65));
        G0((27));
        H0((97));
        A0---B0; A0---C0;
        B0---D0; B0---E0;
        C0---F0; C0---G0;
        D0-.-H0;
    end
```

```mermaid
graph TD
    subgraph 5
        style 5 stroke:#333,stroke-width:2px,fill:grey;
        style H5 fill:red;
        style A5 fill:yellow;
        A5((38));
        B5((76));
        C5((65));
        D5((49));
        E5((49));
        F5((13));
        G5((27));
        H5((97));
        A5-.-B5; A5---C5;
        B5-.-D5; B5---E5;
        C5---F5; C5---G5;
        D5---H5;
    end
    subgraph 4
        style 4 stroke:#333,stroke-width:2px,fill:grey;
        style A4 fill:pink;
        style H4 fill:lightgreen;
        A4((97));
        B4((76));
        C4((65));
        D4((49));
        E4((49));
        F4((13));
        G4((27));
        H4((38));
        A4---B4; A4---C4;
        B4---D4; B4---E4;
        C4---F4; C4---G4;
        D4---H4;
    end
    subgraph 3
        style 3 stroke:#333,stroke-width:2px,fill:grey;
        style A3 fill:yellow;
        style B3 fill:orange;
        A3((49));
        B3((97));
        C3((65));
        D3((49));
        E3((76));
        F3((13));
        G3((27));
        H3((38));
        A3-.-B3; A3---C3;
        B3---D3; B3-.-E3;
        C3---F3; C3---G3;
        D3---H3;
    end
```

- 0-4为构建大顶堆（需要从最后一个非叶结点到根结点进行`HeapAdjust`）；
- 4为构建大顶堆的结果；
- 从4开始为选择最大值排序，后续每次仅需对根节点进行`HeapAdjust`即可。
