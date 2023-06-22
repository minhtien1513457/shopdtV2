import {Injectable, Injector} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class CombinedGuardGuard implements CanActivate {
    constructor(private injector: Injector) {
    }

    async canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Promise<any> {
        const guards = route.data['guards'] || [];
        for (const guard of guards) {
            const instance: CanActivate = this.injector.get(guard);
            let result = instance.canActivate(route, state);

            //Depending on the route result, we may need to await upon it in different ways.
            if (result instanceof Promise) {
                result = await result;
            }

            if (result instanceof Observable) {
                result = await result.toPromise();
            }

            if (result === false || result instanceof UrlTree) {
                return result;
            }
        }
        return true;
    }

}
