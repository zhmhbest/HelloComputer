import sys


def bubble_swap_sort(arr: list) -> list:
    length = len(arr)
    for i in range(0, length):
        for j in range(length - 1, i, -1):
            if arr[j - 1] > arr[j]:
                arr[j - 1], arr[j] = arr[j], arr[j - 1]
    return arr


if __name__ == '__main__':
    line: str = sys.stdin.readline()
    nums = [int(item) for item in line.split(" ")]
    result = bubble_swap_sort(nums)
    print(" ".join([str(item) for item in result]))
    # 17 43 13 4 36 49 23 22 12 17 15 18 33 15 27 32 40 28 30 12
    # 4 12 12 13 15 15 17 17 18 22 23 27 28 30 32 33 36 40 43 49
