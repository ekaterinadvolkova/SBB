{
    document.querySelectorAll('[data-mask]').forEach(item => {
        const mask = new Inputmask(item.dataset.mask);
        if (mask) {
            mask.mask(item);
        }
    });
}
