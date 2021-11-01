import sys
import datetime


class Main:
    @staticmethod
    def dayOfYear(s: str):
        s = s.split('-')
        dt1 = datetime.date(int(s[0]), 1, 1)
        dt2 = datetime.date(int(s[0]), int(s[1]), int(s[2]))
        return (dt2 - dt1).days + 1


if __name__ == '__main__':
    line: str = sys.stdin.readline()
    print(Main.dayOfYear(line))
    # 2016-02-12
