def totalsec():
    time = input().split(':')
    time_hh = int(time[0])
    time_mm = int(time[1])
    time_ss = int(time[2])
    time_totalsec = (time_hh * 3600) + (time_mm * 60) + time_ss
    return time_totalsec

def resttime():
    ntime = totalsec()
    jtime = totalsec()
    rtime = jtime - ntime
    if rtime < 0:
        rtime = rtime + (24 * 3600)
    elif rtime == 0:
        rtime = 24 * 3600
    else:
        pass
    hh = rtime // 3600
    mm = (rtime % 3600) // 60
    ss = (rtime % 3600) % 60

    hh = '%02d' %hh
    mm = '%02d' %mm
    ss = '%02d' %ss
    resttime = hh + ':' + mm + ':' + ss
    return resttime

print(resttime())